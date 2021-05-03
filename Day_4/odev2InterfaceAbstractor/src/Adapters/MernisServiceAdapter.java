package Adapters;


import Abstract.CustomerCheckService;
import Entities.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements CustomerCheckService {

	@Override
	public boolean checkIfRealPerson(Customer customer){
		KPSPublicSoapProxy proxy = new KPSPublicSoapProxy();
		boolean result = true;
		
		try {
			result = proxy.TCKimlikNoDogrula(
					Long.parseLong(customer.getNatioanlityId()), 
					customer.getFirstName().toUpperCase(), 
					customer.getLastName().toUpperCase(),
					customer.getDateOfBirth().getYear());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result) {
			return true;
		}else {
			return false;
		}
	}
	
	

}
