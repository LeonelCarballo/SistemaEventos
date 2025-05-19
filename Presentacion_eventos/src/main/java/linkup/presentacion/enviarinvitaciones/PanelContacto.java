package linkup.presentacion.enviarinvitaciones;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class PanelContacto extends JPanel {
    private String nombreContacto;
    private JCheckBox checkBox;

    public PanelContacto(String nombreContacto, boolean seleccionadoInicial) {
        this.nombreContacto = nombreContacto;
        initComponents(seleccionadoInicial);
    }

    private void initComponents(boolean seleccionadoInicial) {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(Color.WHITE);

        checkBox = new JCheckBox(nombreContacto, seleccionadoInicial);
        add(checkBox);
    }

    // Nuevo método para agregar el ItemListener después
    public void agregarItemListener(ItemListener listener) {
        checkBox.addItemListener(listener);
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public boolean estaSeleccionado() {
        return checkBox.isSelected();
    }

    public void setSeleccionado(boolean seleccionado) {
        checkBox.setSelected(seleccionado);
    }
}
