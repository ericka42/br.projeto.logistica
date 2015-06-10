package br.projeto.logistica.api.googleMaps;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
 
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
 
public class DistanciaWS {
	
	
	
	
	
	private String txtOrigem;
	private String txtDestino;
	
	
	
	
	
    public static String calcular(String origem, String destino) {
        URL url;
        
        try {
            url = new URL(
                    "http://maps.google.es/maps/api/directions/xml?origin="
                            + origem + "&destination=" + destino
                            + "&sensor=false");
 
            Document document = getDocumento(url);
 
            return analisaXml(document);
        } catch (MalformedURLException | DocumentException e) {
            e.printStackTrace();
        }
        return "";
    }
 
    @SuppressWarnings("rawtypes")
    public static String analisaXml(Document document) {
        List list = document
                .selectNodes("//DirectionsResponse/route/leg/distance/text");
 
        Element element = (Element) list.get(list.size() - 1);
 
        return element.getText();
    }
 
    public static Document getDocumento(URL url) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        return document;
    }
 
    public static void main(String[] args) {
    	
//        System.out.println(calcular("07262-160, guarulhos - SP",
//                "Rua sao felix do piaui ,360, Sao Paulo - SP"));
    	
    }
    
    public void entrada(String txtOrigem, String txtDestino){
    	this.txtOrigem = txtOrigem; 
    	this.txtDestino =txtDestino;
    	
    	
    	
    	
    }
 
}
