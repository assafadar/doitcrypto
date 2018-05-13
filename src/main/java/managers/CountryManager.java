package managers;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CountryManager {
	private Map<String,String> countryISOMap = null; 
	private static CountryManager countryManager = null;

	private CountryManager() {
		this.countryISOMap = new HashMap<String,String>(); 
		loadCountryISOMap();
	}
	
	private void loadCountryISOMap() {
		    for (String iso : Locale.getISOCountries()) {
		        Locale l = new Locale("", iso);
		        this.countryISOMap.put(l.getDisplayCountry(), iso);
		    }
	}

	public static CountryManager getInstance() {
		if (countryManager == null) {
			countryManager = new CountryManager();
		}
		return countryManager;
	}
	public String getIsoCode(String country) {
		return this.countryISOMap.get(country);
	}
}
