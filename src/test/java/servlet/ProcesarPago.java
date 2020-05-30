package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.customer.Phone;
import com.mercadopago.resources.datastructures.payment.Payer;
import com.mercadopago.resources.datastructures.preference.Item;

import entidades.Carrito;

 
/**
 * Servlet implementation class ProcesarPago
 */
@WebServlet("/acreditar")
public class ProcesarPago extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcesarPago() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession objsesion = request.getSession(true);
    	ArrayList<Carrito> articulos= objsesion.getAttribute("carrito") == null ? null : (ArrayList) objsesion.getAttribute("carrito");
    	String token = request.getParameter("token");
        String payment_method_id = request.getParameter("payment_method_id");
        int installments = Integer.parseInt(request.getParameter("installments")); 
        String issuer_id = request.getParameter("issuer_id");  
        String accionPago = request.getParameter("accion");
        
        if(accionPago.equals("preparo")){
        	// Crea un objeto de preferencia
//			Preference preference = new Preference();
//	
//			try {
//				 MercadoPago.SDK.setAccessToken("TEST-3914112028621095-052817-97032588420053989d99809fe0f0b95a-51347166");
// 	        	 MercadoPago.SDK.setClientSecret(System.getenv("DSI3cHO2CxJKDG3owXJKBf12rDqSVVQo"));
// 	        	 MercadoPago.SDK.setClientId(System.getenv("3914112028621095"));
// 	        	 
// 	        	// Crea un ítem en la preferencia
// 				Item item = new Item();
// 				item.setTitle("Mi producto")
// 				    .setQuantity(1)
// 				    .setUnitPrice((float) 75.56);
// 				preference.appendItem(item);
//  				System.out.println(item);
//				System.out.println("id: " + preference.getSandboxInitPoint());
//				System.out.println("itemes: " + item.getTitle());	
// 				System.out.println("redirect:" + preference.getPayer());	
// 				//Preference result = preference.save();
//				
//			} catch (MPException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			
        	
        }
        
        if(accionPago.equals("Procesar")){
        	
 	         try {
 	        	 MercadoPago.SDK.setAccessToken("TEST-7869207941215484-053015-9fef7f745b50a8ef07e871e989ace42c-576677712");
 	        	
 	        	 double totalPagar=0.0; 				
   				for (int i = 0; i < articulos.size(); i++) {
					totalPagar = totalPagar+articulos.get(i).getSubtotal();
				}
 	        	 
 	        	//...
 	        	Payment payment = new Payment();
 	        	payment.setTransactionAmount((float)totalPagar)
 	        	       .setToken(token)
 	        	       .setDescription("Gorgeous Aluminum Bag")
 	        	       .setInstallments(installments)
 	        	       .setPaymentMethodId(payment_method_id)
 	        	       .setIssuerId(issuer_id)
 	        	       .setCapture(false)
 	        	       .setPayer(new Payer()
 	        	         .setEmail("darrel.olson@hotmail.com"));
 	        	// Guarda y postea el pago
 	        	payment.save();

 	        	System.out.print(totalPagar);
				response.getWriter().print("Status: " + payment.getStatus() + "/" +
						"Status Detaill: " + payment.getStatusDetail() + "/" +
						"IssuerId:" + payment.getIssuerId() + "/" +
						"id: " + payment.getId() + "/" +
						"PaymentMethodId: " + payment.getPaymentMethodId() + "/" +
						"Payer Email: " + payment.getPayer().getEmail() + "/" +
						"Monto: " + payment.getTransactionAmount() + "/"
						);
 				
			} catch (MPException e) {
				System.out.println(e);
				e.printStackTrace();
			}
        	
        	
        	
        }
    	
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
