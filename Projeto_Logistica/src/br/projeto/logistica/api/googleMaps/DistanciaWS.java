package br.projeto.logistica.api.googleMaps;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.swing.JTextField;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
 

/*
 * classe responsavel para realizar roterizacao 
 * 
 */
public class DistanciaWS implements ActionListener{
	
	JTextField txtOrigem;
	JTextField txtDestino;
	JTextField txtResultado;
	
	/*
	 * contrutor com passagem de parametro
	 * 
	 */
	
    public DistanciaWS(JTextField txtOrigem, JTextField txtDestino, JTextField txtResultado) {
	
		this.txtDestino = txtDestino;
		this.txtOrigem = txtOrigem;
		this.txtResultado = txtResultado;

	}
    
    @Override
    /*
     * 
     * (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		OrigemDestino o = new OrigemDestino();
			if("Calcular".equals(cmd)){
				o.setDestino(txtDestino.getText());
				o.setOrigem(txtOrigem.getText());
				txtResultado.setText(calcular(o));
			}
    }
    
    
/*
 * metodo responsavel por calcular a distancia
 * @return url
 */
	public String calcular(OrigemDestino o) {

        URL url;
        try {
            url = new URL(
                    "http://maps.google.es/maps/api/directions/xml?origin="
                            + o.getOrigem() + "&destination=" + o.getDestino()
                            + "&sensor=false");
 
            Document document = getDocumento(url);
 
            return analisaXml(document);
        } catch (MalformedURLException | DocumentException e) {
            e.printStackTrace();
        }
        return "";
    }
 
	/*
	 * metodo responsavel por analizar xml
	 * @return xml
	 */
    @SuppressWarnings("rawtypes")
    public static String analisaXml(Document document) {
        List list = document
              .selectNodes("//DirectionsResponse/route/leg/distance/text");
 
        Element element = (Element) list.get(list.size() - 1);
 
        return element.getText();
    }
 /*
  * metodo responsavel por criar o document
  * @return document
  */
    public static Document getDocumento(URL url) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        return document;
    }

}
 

