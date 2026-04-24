//package edu.javagroup.tictactoe.frame;
//
//import edu.javagroup.tictactoe.constant.Constants;
//import edu.javagroup.tictactoe.model.Panel;
//import edu.javagroup.tictactoe.model.Step;
//import edu.javagroup.tictactoe.service.CheckWinService;
//import edu.javagroup.tictactoe.service.EnemyService;
//import edu.javagroup.tictactoe.service.EnemyServiceDelegate;
//import edu.javagroup.tictactoe.service.GameService;
//import edu.javagroup.tictactoe.service.PanelService;
//import edu.javagroup.tictactoe.service.impl.EnemyL1ServiceImpl;
//import edu.javagroup.tictactoe.service.impl.EnemyL2ServiceImpl;
//import edu.javagroup.tictactoe.service.impl.EnemyL3ServiceImpl;
//
//import javax.swing.DefaultComboBoxModel;
//import javax.swing.GroupLayout;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JTabbedPane;
//import javax.swing.LayoutStyle;
//import javax.swing.WindowConstants;
//import java.awt.Dimension;
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.lang.reflect.Field;
//import java.lang.reflect.InvocationTargetException;
//
///**
// * @author kaa
// * @version 5.0
// */
//public class MainFrame extends javax.swing.JFrame {
//
//    private static final int BUTTON_SIZE = 100;
//    private static final int FONT_SIZE = 60;
//    private static final Font FONT = new Font("Arial", Font.BOLD, FONT_SIZE);
//    private static final String BUTTON_PREFIX = "jButton";
//    private static final char LENGTH = EnemyService.MAX + 1;
//    private static final char X_SYMBOL = EnemyService.X_SYMBOL;
//    private static final char O_SYMBOL = EnemyService.O_SYMBOL;
//
//    private GameService gameService;
//    private Panel panel;
//    private int level = 1;
//
//    private JTabbedPane jTabbedPane;
//    private JComboBox<String> jComboBox;
//    private JButton jButton00;
//    private JButton jButton01;
//    private JButton jButton02;
//    private JButton jButton10;
//    private JButton jButton11;
//    private JButton jButton12;
//    private JButton jButton20;
//    private JButton jButton21;
//    private JButton jButton22;
//
//    public MainFrame() {
//        initFields();
//        initComponents();
//    }
//
//    private void initFields() {
//        char[][] array = new char[LENGTH][LENGTH];
//        panel = new Panel(array);
//        var panelService = new PanelService(panel);
//        var enemyService = getEnemyServiceDelegate(panelService);
//        var checkWinService = new CheckWinService(panelService);
//        gameService = new GameService(panelService, enemyService, checkWinService);
//    }
//
//    private EnemyServiceDelegate getEnemyServiceDelegate(PanelService panelService) {
//        return switch (level) {
//            case 2 -> new EnemyServiceDelegate(new EnemyL2ServiceImpl(panelService));
//            case 3 -> new EnemyServiceDelegate(new EnemyL3ServiceImpl(panelService));
//            default -> new EnemyServiceDelegate(new EnemyL1ServiceImpl(panelService));
//        };
//    }
//
//    private void initComponents() {
//        jButton00 = new JButton();
//        jButton01 = new JButton();
//        jButton02 = new JButton();
//        jButton10 = new JButton();
//        jButton11 = new JButton();
//        jButton12 = new JButton();
//        jButton20 = new JButton();
//        jButton21 = new JButton();
//        jButton22 = new JButton();
//        jTabbedPane = new JTabbedPane();
//
//        jButton00.setText("");
//        jButton01.setText("");
//        jButton02.setText("");
//        jButton10.setText("");
//        jButton11.setText("");
//        jButton12.setText("");
//        jButton20.setText("");
//        jButton21.setText("");
//        jButton22.setText("");
//
//        jButton00.setSize(BUTTON_SIZE, BUTTON_SIZE);
//        jButton01.setSize(BUTTON_SIZE, BUTTON_SIZE);
//        jButton02.setSize(BUTTON_SIZE, BUTTON_SIZE);
//        jButton10.setSize(BUTTON_SIZE, BUTTON_SIZE);
//        jButton11.setSize(BUTTON_SIZE, BUTTON_SIZE);
//        jButton12.setSize(BUTTON_SIZE, BUTTON_SIZE);
//        jButton20.setSize(BUTTON_SIZE, BUTTON_SIZE);
//        jButton21.setSize(BUTTON_SIZE, BUTTON_SIZE);
//        jButton22.setSize(BUTTON_SIZE, BUTTON_SIZE);
//
//        jButton00.setFocusable(false);
//        jButton01.setFocusable(false);
//        jButton02.setFocusable(false);
//        jButton10.setFocusable(false);
//        jButton11.setFocusable(false);
//        jButton12.setFocusable(false);
//        jButton20.setFocusable(false);
//        jButton21.setFocusable(false);
//        jButton22.setFocusable(false);
//
//        jButton00.setFocusPainted(false);
//        jButton01.setFocusPainted(false);
//        jButton02.setFocusPainted(false);
//        jButton10.setFocusPainted(false);
//        jButton11.setFocusPainted(false);
//        jButton12.setFocusPainted(false);
//        jButton20.setFocusPainted(false);
//        jButton21.setFocusPainted(false);
//        jButton22.setFocusPainted(false);
//
//        jButton00.setFont(FONT);
//        jButton01.setFont(FONT);
//        jButton02.setFont(FONT);
//        jButton10.setFont(FONT);
//        jButton11.setFont(FONT);
//        jButton12.setFont(FONT);
//        jButton20.setFont(FONT);
//        jButton21.setFont(FONT);
//        jButton22.setFont(FONT);
//
//        jButton00.setOpaque(false);
//        jButton01.setOpaque(false);
//        jButton02.setOpaque(false);
//        jButton10.setOpaque(false);
//        jButton11.setOpaque(false);
//        jButton12.setOpaque(false);
//        jButton20.setOpaque(false);
//        jButton21.setOpaque(false);
//        jButton22.setOpaque(false);
//
//        jButton00.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                jButton00ActionPerformed(evt);
//            }
//        });
//
//        jButton01.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                jButton01ActionPerformed(evt);
//            }
//        });
//
//        jButton02.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                jButton02ActionPerformed(evt);
//            }
//        });
//
//        jButton10.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                jButton10ActionPerformed(evt);
//            }
//        });
//
//        jButton11.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                jButton11ActionPerformed(evt);
//            }
//        });
//
//        jButton12.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                jButton12ActionPerformed(evt);
//            }
//        });
//
//        jButton20.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                jButton20ActionPerformed(evt);
//            }
//        });
//
//        jButton21.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                jButton21ActionPerformed(evt);
//            }
//        });
//
//        jButton22.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                jButton22ActionPerformed(evt);
//            }
//        });
//
//        var jComboBoxDimension = new Dimension(50, 33);
//        jComboBox.setModel(new DefaultComboBoxModel<>(new String[]{}));
//        jComboBox.setSize(50, 33);
//        jComboBox.setMinimumSize(jComboBoxDimension);
//        jComboBox.setMaximumSize(jComboBoxDimension);
//        jComboBox.setPreferredSize(jComboBoxDimension);
//        jComboBox.addItem("Level 1");
//        jComboBox.addItem("Level 2");
//        jComboBox.addItem("Level 3");
//        jComboBox.setSelectedIndex(0);
//        jComboBox.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                comboBoxActionPerformed(evt);
//            }
//        });
//
//        JPanel jPanel1 = new JPanel(new GridLayout(3, 3));
//        jPanel1.add(jButton00);
//        jPanel1.add(jButton01);
//        jPanel1.add(jButton02);
//        jPanel1.add(jButton10);
//        jPanel1.add(jButton11);
//        jPanel1.add(jButton12);
//        jPanel1.add(jButton20);
//        jPanel1.add(jButton21);
//        jPanel1.add(jButton22);
//
//        JPanel jPanel2 = new JPanel(new GridLayout(11, 1));
//        jPanel2.add(jComboBox);
//        for (int i = 0; i < 10; i++) {
//            jPanel2.add(new JPanel());
//        }
//
//        jTabbedPane.addTab("Game", jPanel1);
//        jTabbedPane.addTab("Level", jPanel2);
//
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setTitle("TicTacToe");
//        setSize(320, 320);
//        setResizable(false);
//
//        GroupLayout layout = new GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//
//        layout.setHorizontalGroup(
//                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                        .addGroup(layout.createSequentialGroup()
//                                .addContainerGap()
//                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
//                                        .addGroup(layout.createSequentialGroup()
//                                                .addComponent(jTabbedPane, 320, 320, 320)
//                                        )
//                                )
//                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        );
//
//        layout.setVerticalGroup(
//                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                        .addGroup(layout.createSequentialGroup()
//                                .addContainerGap()
//                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                        .addComponent(jTabbedPane, 320, 320, 320)
//                                )
//                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        );
//
//        pack();
//        setLocationRelativeTo(null);
//    }
//
//    private void jButton00ActionPerformed(ActionEvent evt) {
//        step(Thread.currentThread().getStackTrace());
//    }
//
//    private void jButton01ActionPerformed(ActionEvent evt) {
//        step(Thread.currentThread().getStackTrace());
//    }
//
//    private void jButton02ActionPerformed(ActionEvent evt) {
//        step(Thread.currentThread().getStackTrace());
//    }
//
//    private void jButton10ActionPerformed(ActionEvent evt) {
//        step(Thread.currentThread().getStackTrace());
//    }
//
//    private void jButton11ActionPerformed(ActionEvent evt) {
//        step(Thread.currentThread().getStackTrace());
//    }
//
//    private void jButton12ActionPerformed(ActionEvent evt) {
//        step(Thread.currentThread().getStackTrace());
//    }
//
//    private void jButton20ActionPerformed(ActionEvent evt) {
//        step(Thread.currentThread().getStackTrace());
//    }
//
//    private void jButton21ActionPerformed(ActionEvent evt) {
//        step(Thread.currentThread().getStackTrace());
//    }
//
//    private void jButton22ActionPerformed(ActionEvent evt) {
//        step(Thread.currentThread().getStackTrace());
//    }
//
//    private void comboBoxActionPerformed(ActionEvent evt) {
//        level = jComboBox.getSelectedIndex() + 1;
//        initFields();
//        repaintPanel();
//    }
//
//    private void step(StackTraceElement[] stackTraceElements) {
//        var methodName = "";
//        for (StackTraceElement stackTraceElement : stackTraceElements) {
//            if (stackTraceElement.getMethodName().contains(BUTTON_PREFIX)) {
//                methodName = stackTraceElement.getMethodName();
//                break;
//            }
//        }
//        var coord = methodName.replace(BUTTON_PREFIX, "");
//        var vertical = Character.getNumericValue(coord.charAt(0));
//        var horizontal = Character.getNumericValue(coord.charAt(1));
//        if (gameService.isEmptyPoint(vertical, horizontal)) {
//            gameService.setPoint(new Step(X_SYMBOL, vertical, horizontal));
//            repaintPanel();
//        }
//        checkWin();
//    }
//
//    private void repaintPanel() {
//        try {
//            var fields = getClass().getDeclaredFields();
//            for (Field field : fields) {
//                if (field.getName().startsWith(BUTTON_PREFIX)) {
//                    var buttonName = field.getName().replace(BUTTON_PREFIX, "");
//                    var vertical = Character.getNumericValue(buttonName.charAt(0));
//                    var horizontal = Character.getNumericValue(buttonName.charAt(1));
//                    var symbol = panel.getPanels()[vertical][horizontal];
//                    field.setAccessible(true);
//                    var buttonOpaque = field.get(this);
//                    var setTextMethod = JButton.class.getMethod("setText", String.class);
//                    setTextMethod.invoke(buttonOpaque, symbol == Constants.EMPTY_POINT ? "" : String.valueOf(symbol));
//                }
//            }
//        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
//            throw new RuntimeException(ex);
//        }
//    }
//
//    private void checkWin() {
//        if (gameService.checkWin(X_SYMBOL)) {
//            clearPanel("Ты победил!", "УИИИ!!!");
//        }
//        if (gameService.checkWin(O_SYMBOL)) {
//            clearPanel("Компьютер победил!", "УУУУ!!!");
//        }
//        if (gameService.isComplete()) {
//            clearPanel("Ничья :(", "Хммм");
//        }
//    }
//
//    private void clearPanel(String message, String header) {
//        repaintPanel();
//        JOptionPane.showMessageDialog(null, message, header, JOptionPane.INFORMATION_MESSAGE);
//        initFields();
//        repaintPanel();
//    }
//}
