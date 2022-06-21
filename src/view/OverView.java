package view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OverView extends JFrame {
    private JTabbedPane tabPane;
    private JPanel overview, assignment, persons, masterdata, logbook, persList, detailPane, detailPane2, detailPane3;
    // Übersicht, Zuordnung, Personen, Stammdaten, Logbuch
    private JScrollPane personScroll, personScroll2, personScroll3, teamScroll;
    private JTextField nameField, nameField2, nameField3, abteilField, abteilField2, funkField;
    private JComboBox funktionCombo, teamCombo;
    private JCheckBox hrCheckBox, adminCheckBox;
    private JButton addBtn, delBtn, editBtn;
    private boolean isPerson, isAdmin;
    public DefaultListModel list;


    public OverView(boolean isPerson, boolean isAdmin){
        super("Personnel Overview");

        this.isPerson = isPerson;
        this.isAdmin = isAdmin;

        init();

        this.pack();
        setVisible(true);
    }

    private void init(){
        // overview tab:
        GridLayout grid = new GridLayout(1, 2);
        grid.setHgap(25);
        overview = new JPanel(grid);
        overview.setBorder(BorderFactory.createTitledBorder("Personen: "));


        String[] persList = { "Hans Fritz", "Nimai Leuenberger", "Nick Gur", "Nöck Gur", "Nik Gur", "Nick Hallo", "Nick Gur", "Nick Gur", "Nick Gur"};
        JList listPers = new JList(persList);
        listPers.setSelectedIndex(0);
        listPers.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                nameField.setText(listPers.getSelectedValue().toString());
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
        abteilField = new JTextField("Die richtige Abteilung");
        abteilField.setEditable(false);
        c.gridx = 1; c.gridy = 1; detailPane.add(abteilField, c);
        // TODO: make a list of the class Person and get its abteilung
        c.gridx = 0; c.gridy = 2; detailPane.add(new JLabel("Funktion: "), c);
        funkField = new JTextField("Die richtige Funktion");
        funkField.setEditable(false);
        c.gridx = 1; c.gridy = 2; detailPane.add(funkField, c);
        String[] teamList = {"More cash", "Money", "Free Giveaway", "Dollars", "Cars", "Boats", "Mansions", "Women"};
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


        JList listPers2 = new JList(persList);
        listPers2.setSelectedIndex(0);
        listPers2.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                nameField2.setText(listPers2.getSelectedValue().toString());
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
        abteilField2 = new JTextField("richtige Abteilung");
        detailPane2.add(abteilField2, c);
        c.gridx = 0; c.gridy = 2;
        detailPane2.add(new JLabel("Funktion: "), c);
        c.gridx = 1; c.gridy = 2;
        String[] funkList = {"COO", "CFO", "Sekretärin", "Angestellter", "Kaffeemacher", "Putzfrau", "Hund"};
        funktionCombo = new JComboBox(funkList);
        detailPane2.add(funktionCombo, c);
        c.gridx = 0; c.gridy = 3;
        detailPane2.add(new JLabel("Team: "), c);
        c.gridx = 1; c.gridy = 3;
        teamCombo = new JComboBox(teamList);
        detailPane2.add(teamCombo, c);


        assignment.add(personScroll2);
        assignment.add(detailPane2);


        // persons tab:
        persons = new JPanel(new GridLayout(1,2));
        persons.setBorder(BorderFactory.createTitledBorder("Personen bearbeiten: "));

        list = new DefaultListModel<String>();
        for (int i = 0; i < persList.length; i++) {
            list.add(i, persList[i]);
        }
        JList<String> listPers3 = new JList<String>(list);
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
                AddPersDialog addPersDialog = new AddPersDialog(listPers3);
                list.add(list.getSize(), addPersDialog.getNameField());
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
        nameField3 = new JTextField(listPers3.getSelectedValue());
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

        persons.add(leftPane);
        persons.add(detailPane3);


        masterdata = new JPanel();
        logbook = new JPanel();


        tabPane = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
        tabPane.addTab("Übersicht", overview);
        tabPane.addTab("Zuordnung", assignment);
        tabPane.addTab("Personen", persons);
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
    private JTextField nameField;
    private JCheckBox hrCheckBox, adminCheckBox;
    public JButton saveBtn, abortBtn;
    public JList listPers;

    AddPersDialog(JList listPers){
        this.dialog = this;
        this.setTitle("Person erfassen");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        this.listPers = listPers;
        dataPane = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0; c.gridy = 0;
        dataPane.add(new JLabel("Name: "), c);
        c.gridx = 1;
        nameField = new JTextField(listPers.getSelectedValue().toString());
        dataPane.add(nameField, c);
        c.gridx = 0; c.gridy = 1;
        dataPane.add(new JLabel("HR-Mitarbeiter: "), c);
        c.gridx = 1;
        hrCheckBox = new JCheckBox();
        dataPane.add(hrCheckBox, c);
        c.gridx = 0; c.gridy = 2;
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
                listPers.setSelectedValue(nameField.getText(), true);

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