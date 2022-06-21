package view;

import model.company.Department;
import model.company.JobFunctions;
import model.company.Teams;
import model.employees.Participation;
import model.employees.Person;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class OverView extends JFrame {
    private JTabbedPane tabPane;
    private JPanel overview, assignment, personsPane, masterdata, logbook, persList, detailPane, detailPane2, detailPane3;
    // Übersicht, Zuordnung, Personen, Stammdaten, Logbuch
    private JScrollPane personScroll, personScroll2, personScroll3, teamScroll;
    private JTextField nameField, nameField2, nameField3, abteilField, abteilField2, funkField;
    private JComboBox funktionCombo, teamCombo;
    private JCheckBox hrCheckBox, adminCheckBox;
    private JButton addBtn, delBtn, editBtn;
    private boolean isPerson, isAdmin;
    public DefaultListModel list;

    public Vector<Person> persons;
    public Vector<Participation> participations;
    public Vector<Department> department;
    public Vector<JobFunctions> jobFunctions;
    public Vector<Teams> teams;


    public OverView(boolean isPerson, boolean isAdmin){
        super("Personnel Overview");

        this.isPerson = isPerson;
        this.isAdmin = isAdmin;

        init();

        this.pack();
        setVisible(true);
    }

    private void init(){
        // persons:
        persons = new Vector<>();
        department = new Vector<>();
        jobFunctions = new Vector<>();
        teams = new Vector<>();
        department.add(new Department("Abteilung 1"));
        department.add(new Department("Abteilung 2"));
        department.add(new Department("Abteilung 3"));

        jobFunctions.add(new JobFunctions("Chef"));
        jobFunctions.add(new JobFunctions("CFO"));
        jobFunctions.add(new JobFunctions("COO"));

        teams.add(new Teams("Team 1"));
        teams.add(new Teams("Team 2"));
        teams.add(new Teams("Team 3"));

        participations = new Vector<>();
        participations.add(new Participation(jobFunctions, teams, department.get(1)));
        participations.add(new Participation(jobFunctions, teams, department.get(2)));
        participations.add(new Participation(jobFunctions, teams, department.get(0)));

        persons.add(new Person("Nimai", "Leuenberger", participations.get(1)));
        persons.add(new Person("Stef", "De Giorgi", participations.get(0)));
        persons.add(new Person("Andrej", "Velo", participations.get(2)));

        // overview tab:
        GridLayout grid = new GridLayout(1, 2);
        grid.setHgap(25);
        overview = new JPanel(grid);
        overview.setBorder(BorderFactory.createTitledBorder("Personen: "));


        Vector<String> list = new Vector<>();
        list.add(persons.get(0).getFirstName() + " " + persons.get(0).getLastName());
        list.add(persons.get(1).getFirstName() + " " + persons.get(1).getLastName());
        list.add(persons.get(2).getFirstName() + " " + persons.get(2).getLastName());
        JList listPers = new JList(list);
        listPers.setSelectedIndex(0);
        listPers.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                nameField.setText(listPers.getSelectedValue().toString());
                abteilField.setText(persons.get(listPers.getSelectedIndex()).getParticipation().getDepartementName());
                funkField.setText(persons.get(listPers.getSelectedIndex()).getParticipation().getFunctionName(listPers.getSelectedIndex()));
            }
        });
        personScroll = new JScrollPane(listPers, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        detailPane = new JPanel(new GridBagLayout());
        detailPane.setBorder(BorderFactory.createTitledBorder("Detail: "));
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0; c.gridy = 0; detailPane.add(new JLabel("Name: "), c);
        nameField = new JTextField(listPers.getSelectedValue().toString());
        nameField.setEditable(false);
        c.gridx = 1; c.gridy = 0; detailPane.add(nameField, c);
        c.gridx = 0; c.gridy = 1; detailPane.add(new JLabel("Abteilung: "), c);
        abteilField = new JTextField(persons.get(listPers.getSelectedIndex()).getParticipation().getDepartementName());
        System.out.println(listPers.getSelectedIndex());
        abteilField.setEditable(false);
        c.gridx = 1; c.gridy = 1; detailPane.add(abteilField, c);
        // TODO: make a list of the class Person and get its abteilung
        c.gridx = 0; c.gridy = 2; detailPane.add(new JLabel("Funktion: "), c);
        funkField = new JTextField(persons.get(listPers.getSelectedIndex()).getParticipation().getFunctionName(listPers.getSelectedIndex()));
        funkField.setEditable(false);
        c.gridx = 1; c.gridy = 2; detailPane.add(funkField, c);
        String[] teamList =  {persons.get(0).getParticipation().getTeamName(0), persons.get(0).getParticipation().getTeamName(1), persons.get(0).getParticipation().getTeamName(2)};
        JList listTeam = new JList(teamList);
        teamScroll = new JScrollPane(listTeam, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        c.gridx = 0; c.gridy = 3; detailPane.add(new JLabel("Teams: "), c);
        c.gridx = 1; c.gridy = 3;
        c.weightx = 1; c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        detailPane.add(teamScroll, c);


        overview.add(personScroll);
        overview.add(detailPane);


        // assignment tab:
        assignment = new JPanel(new GridLayout(1,2));
        assignment.setBorder(BorderFactory.createTitledBorder("Personen bearbeiten: "));


        JList listPers2 = new JList(list);
        listPers2.setSelectedIndex(0);
        listPers2.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                nameField2.setText(listPers2.getSelectedValue().toString());
                abteilField2.setText(persons.get(listPers2.getSelectedIndex()).getParticipation().getDepartementName());
                funktionCombo.setSelectedIndex(listPers2.getSelectedIndex());
                teamCombo.setSelectedIndex(listPers2.getSelectedIndex());
            }
        });
        personScroll2 = new JScrollPane(listPers2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        detailPane2 = new JPanel(new GridBagLayout());
        detailPane2.setBorder(BorderFactory.createTitledBorder("Detail: "));
        c.gridx = 0; c.gridy = 0;
        detailPane2.add(new JLabel("Name: "), c);
        c.gridx = 1; c.gridy = 0;
        nameField2 = new JTextField(listPers2.getSelectedValue().toString());
        nameField2.setEditable(false);
        detailPane2.add(nameField2, c);
        c.gridx = 0; c.gridy = 1;
        detailPane2.add(new JLabel("Abteilung: "), c);
        c.gridx = 1; c.gridy = 1;
        abteilField2 = new JTextField(persons.get(listPers2.getSelectedIndex()).getParticipation().getDepartementName());
        abteilField2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    persons.get(listPers2.getSelectedIndex()).getParticipation().getDepartment().setName(abteilField2.getText());
                    abteilField2.setText(persons.get(listPers2.getSelectedIndex()).getParticipation().getDepartementName());
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        detailPane2.add(abteilField2, c);
        c.gridx = 0; c.gridy = 2;
        detailPane2.add(new JLabel("Funktion: "), c);
        c.gridx = 1; c.gridy = 2;
        String[] funkList = {"COO", "CFO", "Chef"};
        funktionCombo = new JComboBox(funkList);
        funktionCombo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){
                    int index = listPers2.getSelectedIndex();
                    persons.get(index).getParticipation().getFunction(index).setName(e.getItem().toString());
                    funktionCombo.setSelectedItem(persons.get(index).getParticipation().getFunction(index).getName());
                    System.out.println(funktionCombo.getSelectedItem());
                }
                int index = listPers2.getSelectedIndex();
                persons.get(index).getParticipation().getFunction(index).setName(e.getItem().toString());
                funktionCombo.setSelectedItem(persons.get(index).getParticipation().getFunction(index).getName());
            }
        });
        detailPane2.add(funktionCombo, c);
        c.gridx = 0; c.gridy = 3;
        detailPane2.add(new JLabel("Team: "), c);
        c.gridx = 1; c.gridy = 3;
        teamCombo = new JComboBox(teamList);
        detailPane2.add(teamCombo, c);


        assignment.add(personScroll2);
        assignment.add(detailPane2);


        // persons tab:
        personsPane = new JPanel(new GridLayout(1,2));
        personsPane.setBorder(BorderFactory.createTitledBorder("Personen bearbeiten: "));


        JList listPers3 = new JList(list);
        listPers3.setSelectedIndex(0);
        //JList listPers3 = new JList(persList);
        listPers3.setSelectedIndex(0);
        listPers3.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                nameField3.setText(listPers3.getSelectedValue().toString());
            }
        });
        personScroll3 = new JScrollPane(listPers3, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JPanel btnPane = new JPanel(new FlowLayout());
        ImageIcon addImg = new ImageIcon("./imgs/add.png");
        ImageIcon delImg = new ImageIcon("./imgs/del.png");
        ImageIcon editImg = new ImageIcon("./imgs/edit.png");
        addBtn = new JButton(addImg);
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddPersDialog addPersDialog = new AddPersDialog(persons);
                list.add(list.size(), addPersDialog.getNameField());
            }
        });
        delBtn = new JButton(delImg);
        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });
        editBtn = new JButton(editImg);
        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });
        btnPane.add(addBtn);
        btnPane.add(delBtn);
        btnPane.add(editBtn);

        JPanel leftPane = new JPanel(new BorderLayout());
        leftPane.add(personScroll3, BorderLayout.CENTER);
        leftPane.add(btnPane, BorderLayout.SOUTH);


        detailPane3 = new JPanel(new GridBagLayout());
        detailPane3.setBorder(BorderFactory.createTitledBorder("Detail: "));
        c.gridx = 0; c.gridy = 0;
        detailPane3.add(new JLabel("Name: "), c);
        c.gridx = 1;
        nameField3 = new JTextField(listPers3.getSelectedValue().toString());
        nameField3.setEditable(false);
        detailPane3.add(nameField3, c);
        c.gridx = 0; c.gridy = 1;
        detailPane3.add(new JLabel("HR-Mitarbeiter: "), c);
        c.gridx = 1;
        hrCheckBox = new JCheckBox();
        hrCheckBox.setEnabled(false);
        detailPane3.add(hrCheckBox, c);
        c.gridx = 0; c.gridy = 2;
        detailPane3.add(new JLabel("Administrator: "), c);
        c.gridx = 1;
        adminCheckBox = new JCheckBox();
        adminCheckBox.setEnabled(false);
        detailPane3.add(adminCheckBox, c);

        personsPane.add(leftPane);
        personsPane.add(detailPane3);


        masterdata = new JPanel();
        logbook = new JPanel();

        // tab pane:
        tabPane = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
        tabPane.addTab("Übersicht", overview);
        tabPane.addTab("Zuordnung", assignment);
        tabPane.addTab("Personen", personsPane);
        if (isAdmin){
            tabPane.addTab("Stammdaten", masterdata);
            tabPane.addTab("Logbuch", logbook);
        }

        this.getContentPane().add(tabPane);
    }
}

class AddPersDialog extends JDialog{
    private JDialog dialog;
    private JPanel dataPane, btnPane;
    private JTextField nameField, lastNameField;
    private JCheckBox hrCheckBox, adminCheckBox;
    public JButton saveBtn, abortBtn;
    private Vector<Person> p;

    AddPersDialog(Vector<Person> persons){
        this.dialog = this;
        this.setTitle("Person erfassen");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        this.p = persons;
        dataPane = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0; c.gridy = 0;
        dataPane.add(new JLabel("Name: "), c);
        c.gridx = 1;
        nameField = new JTextField("");
        dataPane.add(nameField, c);
        c.gridx = 0; c.gridy = 1;
        dataPane.add(new JLabel("Lastname: "), c);
        c.gridx = 1;
        lastNameField = new JTextField("");
        dataPane.add(lastNameField, c);
        c.gridx = 0; c.gridy = 2;
        dataPane.add(new JLabel("HR-Mitarbeiter: "), c);
        c.gridx = 1;
        hrCheckBox = new JCheckBox();
        dataPane.add(hrCheckBox, c);
        c.gridx = 0; c.gridy = 3;
        dataPane.add(new JLabel("Administrator: "), c);
        c.gridx = 1;
        adminCheckBox = new JCheckBox();
        dataPane.add(adminCheckBox, c);


        btnPane = new JPanel(new FlowLayout());
        abortBtn = new JButton("Abbrechen");
        abortBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        btnPane.add(abortBtn);

        saveBtn = new JButton("Speichern");
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //p.add(nameField.getText(), lastNameField.getText(), new Participation(new JobFunctions("f"), new Teams("j"), new Department("j")));
                dialog.dispose();
            }
        });
        btnPane.add(saveBtn);


        this.getContentPane().add(dataPane, BorderLayout.CENTER);
        this.getContentPane().add(btnPane, BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);
    }

    public String getNameField(){
        return this.nameField.getText().toString();
    }
}