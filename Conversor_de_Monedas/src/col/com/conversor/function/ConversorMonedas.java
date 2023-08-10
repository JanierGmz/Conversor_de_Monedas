package col.com.conversor.function;
/**
 * @author Janier Yulder Gomez Galindez
 */
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class ConversorMonedas {
    private Map<String, Double> tasasDeCambio;

    /**
     * Constructor que define un HashMap para luego hacer las conversiones
     */
    public ConversorMonedas() {
        tasasDeCambio = new HashMap<>();
        tasasDeCambio.put("USD", 3987.53);
        tasasDeCambio.put("EUR", 4390.45);
        tasasDeCambio.put("GBP", 5068.87);
        tasasDeCambio.put("JPY", 27.60);
        tasasDeCambio.put("KRW", 3.03);
    }
    
    /**
     * Metodo que retorna un String de manera estética
     * @param valor
     * @return
     */
    private String formatoEstetico(double valor) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        return decimalFormat.format(valor);
    }

    /**
     * Metodo que realiza la conversion de Monedas
     * @param monedaOrigen
     * @param monedaDestino
     * @param valor
     * @return
     */
    public String convertir(String monedaOrigen,String monedaDestino, double valor) {
    	if (monedaOrigen.equals(monedaDestino)) {
			return "Resultado" + valor;
		}
        double resultado = 0;
        if (monedaOrigen.equals("COP")) {
        	double tasaOrigen = tasasDeCambio.get(monedaDestino);
            resultado = valor / tasaOrigen;
            return  valor + " "+monedaOrigen+" equivale a " + formatoEstetico(resultado) + " "+monedaDestino   ;
        } else {
        	double tasaOrigen = tasasDeCambio.get(monedaOrigen);
            resultado = valor * tasaOrigen;
            return valor + " " + monedaOrigen + " equivale a " + formatoEstetico(resultado)+ " "+monedaDestino;
        }
    }

    /**
     * Metodo Para convertir de String a Double
     * @param valorString
     * @return
     * @throws Exception
     */
    public double string_double(String valorString) throws Exception{
		return Double.parseDouble(valorString);
	}
}
