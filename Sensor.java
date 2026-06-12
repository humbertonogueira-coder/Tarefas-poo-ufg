import java.util.Date;
import java.text.SimpleDateFormat;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DataType;


@DatabaseTable(tableName = "tbl_sensor")
public class Sensor {
    
    
       
    @DatabaseField(generatedId = true)
    private int id;
    
    @DatabaseField
    private String categoria;
    
    @DatabaseField
    private String nome;
    
    @DatabaseField
    private String undMedida;
    
    @DatabaseField
    private String tipoDado;
    
    @DatabaseField
    private Double valorAtual=0.0;
    
    // Adicione isto em Sensor.java (pode ser logo acima do outro construtor)
    public Sensor() {
    // Exigido pelo ORMLite
    }
    
    Sensor(String categoria, String nome, String tipoDado, String undMedida) {
        this.setCategoria(categoria);
        this.setNome(nome);
        this.setTipoDado(tipoDado);
        this.setUndMedida(undMedida);
        this.setValor(0);
        System.out.println("Sensor criado - id = " + this.getId());

    }
    
    public void setValor(double valor){
    if ("1/0".equals(this.getTipoDado()) && (valor == 1 || valor == 0)){
        this.valorAtual = valor;    
        } else if (!"1/0".equals(this.getTipoDado())){
        this.valorAtual = valor;    
        } else {
        System.out.println("Nada feito. É esperado valor tipo: " + this.getTipoDado());
        }
    }

    public double getValor(){
        return this.valorAtual;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setUndMedida(String undMedida) {
        this.undMedida = undMedida;
    }
    public void setTipoDado(String tipoDado) {
        this.tipoDado = tipoDado;
    }
    public int getId() {
        return this.id;
    }
    public String getCategoria() {
        return this.categoria;
    }
    public String getNome() {
        return this.nome;
    }
    public String getUndMedida() {
        return this.undMedida;
    }
    public String getTipoDado() {
        return this.tipoDado;
    }

    public void exibirSensor(){
        System.out.println("id: "+this.getId());
        System.out.println("Categoria: "+this.getCategoria());
        System.out.println("Nome: "+this.getNome());
        System.out.println("TipoDado: "+this.getTipoDado());
        System.out.println("UndMedida: "+this.getUndMedida());
        System.out.println("Valor: "+this.getValor());
    }
}
