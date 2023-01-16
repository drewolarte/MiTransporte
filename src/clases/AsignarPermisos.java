package clases;

import vistas.FrmPrincipal;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

public class AsignarPermisos {

    private JFrame frm = new JFrame();
    private ArrayList<String> listaDePermisos = new ArrayList<String>();

    public AsignarPermisos(JFrame ObjFrm, ArrayList<String> listaPermisos) {
        this.frm = ObjFrm;
        this.listaDePermisos = listaPermisos;
    }

    public boolean asignarPermisos() {
        boolean flag = false;
        if (this.listaDePermisos.size() > 0) {
            for (String permiso : this.listaDePermisos) {
                this.asignarPermiso(permiso);
            }
            flag = true;
        }
        return flag;
    }

    private void asignarPermiso(String permiso) {
        Field[] arrMet = this.frm.getClass().getDeclaredFields();
        for (int i = 0; i < arrMet.length; i++) {
            if (arrMet[i].getName().equals(permiso)) {
                try {
                    arrMet[i].setAccessible(true);
                    JMenuItem nombreDeVariable = (JMenuItem) arrMet[i].get(this.frm);
                    nombreDeVariable.setEnabled(true);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
