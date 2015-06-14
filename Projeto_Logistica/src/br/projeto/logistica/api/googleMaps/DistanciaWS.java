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

import com.sun.xml.internal.txw2.TXW;
 
public class DistanciaWS implements ActionListener{
	
	JTextField txtOrigem;
	JTextField txtDestino;
	JTextField txtResultado;
	
    public DistanciaWS(JTextField txtOrigem, JTextField txtDestino, JTextField txtResultado) {
	
		this.txtDestino = txtDestino;
		this.txtOrigem = txtOrigem;
		this.txtResultado = txtResultado;

	}
    
    @Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		OrigemDestino o = new OrigemDestino();
			if("Calcular".equals(cmd)){
				o.setDestino(txtDestino.getText());
				o.setOrigem(txtOrigem.getText());
				txtResultado.setText(calcular(o));
			}
    }
    

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

}
 

