package Adapter;

import Abstract.UserCheckService;
import Entities.User;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements UserCheckService{

	@Override
	public boolean checkIfRealUser(User user) {
		
		KPSPublicSoapProxy proxy = new KPSPublicSoapProxy();
		try {
			return proxy.TCKimlikNoDogrula(
					Long.parseLong(user.getNationalityId()),
					user.getFirstName(),
					user.getLastName(),
					user.getBirthDay().getYear());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
