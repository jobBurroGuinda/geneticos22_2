package nReynas

import nReynas.Selection.SelectionType
import java.awt.EventQueue
import java.awt.event.ActionEvent
import java.util.logging.Level
import java.util.logging.Logger
import javax.swing.*

class ManagerJFrame : JFrame() {
    var conf: Configuration

    private fun initComponents() {
        jButtonMuta = JButton()
        jTextFieldMuta = JTextField()
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        jButtonMuta!!.text = "Cambiar Mutate"
        jButtonMuta!!.addActionListener { evt -> jButtonMutaActionPerformed(evt) }
        val layout = GroupLayout(contentPane)
        contentPane.layout = layout
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(
                    layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldMuta, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonMuta)
                        .addContainerGap(201, Short.MAX_VALUE.toInt())
                )
        )
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(
                    layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(
                            layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonMuta)
                                .addComponent(
                                    jTextFieldMuta,
                                    GroupLayout.PREFERRED_SIZE,
                                    GroupLayout.DEFAULT_SIZE,
                                    GroupLayout.PREFERRED_SIZE
                                )
                        )
                        .addContainerGap(258, Short.MAX_VALUE.toInt())
                )
        )
        pack()
    }

    private fun jButtonMutaActionPerformed(evt: ActionEvent) {
        val muta = jTextFieldMuta!!.text.toDouble()
        conf.probMutate = muta
    }

    private var jButtonMuta: JButton? = null
    private var jTextFieldMuta: JTextField? = null

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
            try {
                for (info in UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus" == info.name) {
                        UIManager.setLookAndFeel(info.className)
                        break
                    }
                }
            } catch (ex: ClassNotFoundException) {
                Logger.getLogger(ManagerJFrame::class.java.name).log(Level.SEVERE, null, ex)
            } catch (ex: InstantiationException) {
                Logger.getLogger(ManagerJFrame::class.java.name).log(Level.SEVERE, null, ex)
            } catch (ex: IllegalAccessException) {
                Logger.getLogger(ManagerJFrame::class.java.name).log(Level.SEVERE, null, ex)
            } catch (ex: UnsupportedLookAndFeelException) {
                Logger.getLogger(ManagerJFrame::class.java.name).log(Level.SEVERE, null, ex)
            }
            //</editor-fold>

            /* Create and display the form */EventQueue.invokeLater { ManagerJFrame().isVisible = true }
        }
    }

    init {
        initComponents()
        conf = Configuration(1000000, 100, 0.00001, 0.2, arrayOf(SelectionType.RANDOM, SelectionType.TOURNAMENT), 15)
        val gen = GeneticoNReinas(conf)
        val hilo = Thread(gen)
        hilo.start()
        println()
    }
}
