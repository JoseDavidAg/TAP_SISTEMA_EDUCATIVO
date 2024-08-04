/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author ambro
 */
import controlador.inicio;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;import controlador.inicio;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScheduleFrame extends JFrame {

    private JComboBox<String> professorComboBox;
    private JTable scheduleTable;
    private DefaultTableModel tableModel;
    private JButton saveButton;

    private JComboBox<String> yearComboBox;
    private JComboBox<String> subjectComboBox;
    private JComboBox<String> groupComboBox;
    private Map<String, Map<String, List<String>>> yearToSubjectToGroups;
     private JButton openOtherFrameButton;
     ArrayList<String> profes;
     inicio inicio = new inicio();
       
    public ScheduleFrame() throws SQLException {
         inicio.start("lizbethcb@gmail.com");

        profes = inicio.getModels("SELECT idUsuario FROM tb_usuario WHERE tipo = ?", "idUsuario", "Profesor");
        ArrayList<String> profesName = inicio.getModels("SELECT usuario FROM tb_usuario WHERE tipo = ?", "usuario", "Profesor");


        // Configura el frame principal
        setTitle("Asignación de Horarios");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Inicialización del JComboBox para los años
        yearComboBox = new JComboBox<>();
        yearComboBox.addItem("Selecciona Año");
        yearComboBox.addItem("1");
        yearComboBox.addItem("2");
        yearComboBox.addItem("3");

        // Datos de ejemplo para materias y grupos por año
        yearToSubjectToGroups = new HashMap<>();

        // Ejemplo para 1
        Map<String, List<String>> subjectToGroups1 = new HashMap<>();
        ArrayList<String> materias1 = inicio.getModels("SELECT idMateria FROM materia WHERE IdCurso = ?", "idMateria", "1");
        
         ArrayList<String> grupos = inicio.getModels("SELECT IdGrupo FROM grupo WHERE IdCurso = ?", "idGrupo", "1");
        
        for (String materia : materias1) {
            subjectToGroups1.put(materia, grupos);
          
        }
        yearToSubjectToGroups.put("1", subjectToGroups1);

        // Ejemplo para 2
        Map<String, List<String>> subjectToGroups2 = new HashMap<>();
        ArrayList<String> materias2 = inicio.getModels("SELECT idMateria FROM materia WHERE IdCurso = ?", "idMateria", "2");
        ArrayList<String> grupos2 = inicio.getModels("SELECT IdGrupo FROM grupo WHERE IdCurso = ?", "idGrupo", "2");
        for (String materia : materias2) {
            subjectToGroups2.put(materia, grupos2);
        }
        yearToSubjectToGroups.put("2", subjectToGroups2);

        // Ejemplo para 3
        Map<String, List<String>> subjectToGroups3 = new HashMap<>();
        ArrayList<String> materias3 = inicio.getModels("SELECT idMateria FROM materia WHERE IdCurso = ?", "idMateria", "3");
          ArrayList<String> grupos3 = inicio.getModels("SELECT IdGrupo FROM grupo WHERE IdCurso = ?", "idGrupo", "3");
        for (String materia : materias3) {
            subjectToGroups3.put(materia, grupos3);
        }
        yearToSubjectToGroups.put("3", subjectToGroups3);

        // Configuración del JComboBox para materias y grupos
        subjectComboBox = new JComboBox<>();
        groupComboBox = new JComboBox<>();

        // Panel superior para selección de profesor
        JPanel topPanel = new JPanel(new FlowLayout());
        JLabel professorLabel = new JLabel("Seleccionar Profesor:");
        professorComboBox = new JComboBox<>();
        professorComboBox.addItem("Selecciona Profesor"); // Agrega un ítem predeterminado

        // Asumiendo que profes es una lista de nombres de profesores
        for (int i = 0; i < profes.size(); i++) {
            professorComboBox.addItem(profes.get(i) + ": " + profesName.get(i));
        }

        topPanel.add(professorLabel);
        topPanel.add(professorComboBox);

        // Panel central con la tabla de horarios
        JPanel centerPanel = new JPanel(new BorderLayout());
        String[] columnNames = {"Hora", "Año", "Materia", "Grupo"};
        Object[][] data = {
            {"08:00 - 09:00", "Selecciona Año", "Selecciona Materia", "Selecciona Grupo"},
            {"09:00 - 10:00", "Selecciona Año", "Selecciona Materia", "Selecciona Grupo"},
            {"10:00 - 11:00", "Selecciona Año", "Selecciona Materia", "Selecciona Grupo"},
            {"11:00 - 12:00", "Selecciona Año", "Selecciona Materia", "Selecciona Grupo"},
            {"12:00 - 13:00", "Selecciona Año", "Selecciona Materia", "Selecciona Grupo"},
            {"13:00 - 14:00", "Selecciona Año", "Selecciona Materia", "Selecciona Grupo"}
        };
        tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Solo las columnas "Año", "Materia" y "Grupo" deben ser editables
                return column == 1 || column == 2 || column == 3;
            }
        };
        scheduleTable = new JTable(tableModel);

        // Ajustar el ancho de las columnas
        scheduleTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        scheduleTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        scheduleTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        scheduleTable.getColumnModel().getColumn(3).setPreferredWidth(150);

        // Asignar editores a las celdas
        scheduleTable.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(yearComboBox) {
            @Override
            public Object getCellEditorValue() {
                return yearComboBox.getSelectedItem();
            }

            @Override
            public boolean stopCellEditing() {
                String selectedYear = (String) yearComboBox.getSelectedItem();
                updateSubjectComboBox(selectedYear);
                return super.stopCellEditing();
            }
        });

        scheduleTable.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(subjectComboBox) {
            @Override
            public Object getCellEditorValue() {
                return subjectComboBox.getSelectedItem();
            }

            @Override
            public boolean stopCellEditing() {
                String selectedSubject = (String) subjectComboBox.getSelectedItem();
                updateGroupComboBox(selectedSubject);
                return super.stopCellEditing();
            }
        });

        scheduleTable.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(groupComboBox));

        // Mejorar el diseño de la tabla
        scheduleTable.setGridColor(Color.BLACK);
        scheduleTable.setSelectionBackground(new Color(184, 207, 229));
        scheduleTable.setSelectionForeground(Color.BLACK);
        scheduleTable.setRowHeight(30); // Ajusta la altura de las filas

        JScrollPane scrollPane = new JScrollPane(scheduleTable);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        // Panel inferior con el botón de guardar
        JPanel bottomPanel = new JPanel(new FlowLayout());
        saveButton = new JButton("Guardar");
        bottomPanel.add(saveButton);

         // Inicializa el botón para abrir el otro frame
    openOtherFrameButton = new JButton("Regresar");
    bottomPanel.add(openOtherFrameButton);
    
        // Agrega los paneles al frame
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Acción del botón de guardar
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(professorComboBox.getSelectedIndex()==0){
              JOptionPane.showMessageDialog(null, "Seleccione un profesor a signar Horario.");
        }else{
                   try {
                       saveSchedule();
                   } catch (SQLException ex) {
                       Logger.getLogger(ScheduleFrame.class.getName()).log(Level.SEVERE, null, ex);
                   }
        }
                
            }
        });
        openOtherFrameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaPrincipalP VistaPrincipalP = new VistaPrincipalP();
        VistaPrincipalP.setVisible(true);
        dispose();
            }
        });
    
    }

    private void updateSubjectComboBox(String year) {
        subjectComboBox.removeAllItems();
        Map<String, List<String>> subjectToGroups = yearToSubjectToGroups.get(year);
        if (subjectToGroups != null) {
            for (String subject : subjectToGroups.keySet()) {
                subjectComboBox.addItem(subject);
            }
        }
    }

    private void updateGroupComboBox(String subject) {
        groupComboBox.removeAllItems();
        String selectedYear = (String) yearComboBox.getSelectedItem();
        Map<String, List<String>> subjectToGroups = yearToSubjectToGroups.get(selectedYear);
        if (subjectToGroups != null) {
            List<String> groups = subjectToGroups.get(subject);
            if (groups != null) {
                for (String group : groups) {
                    groupComboBox.addItem(group);
                }
            }
        }
    }

    private void saveSchedule() throws SQLException {
      
        // Aquí iría el código para guardar los datos en la base de datos
        int selectedRowCount = scheduleTable.getRowCount();
        for (int row = 0; row < selectedRowCount; row++) {
            String hora = (String) tableModel.getValueAt(row, 0);
            String año = (String) tableModel.getValueAt(row, 1);
            String materia = (String) tableModel.getValueAt(row, 2);
            String grupo = (String) tableModel.getValueAt(row, 3);
            String profesor = (String) professorComboBox.getSelectedItem();
            int profe= Integer.parseInt(profes.get(professorComboBox.getSelectedIndex()-1));
           inicio.actualizaMateriaProfesor(materia,profe,grupo);
            // Aquí deberías agregar el código para guardar en la base de datos
        }
    }

   
}

