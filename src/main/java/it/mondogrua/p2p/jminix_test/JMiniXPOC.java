package it.mondogrua.p2p.jminix_test;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.jminix.console.tool.StandaloneMiniConsole;


/**
 *
 */
public class JMiniXPOC implements JMiniXPOCMBean {
    
    DataModel model = new DataModel();
    DataView view = new DataView(this);
    
    public void changeLable() {
        final String currentText = model.getNextText();
        model.setNextText(view.getText());
        
        view.setText(currentText); 
    }

    public String getNextText() {
        return model.getNextText();
    }

    private void run() {
        view.run(this);
    }
    
    public static void main( String[] args ) throws Exception {
        
        StandaloneMiniConsole console = new StandaloneMiniConsole(8088);;
        
        JMiniXPOC instance = new JMiniXPOC();
        
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("it.mondogrua.p2p.jminix_test:type=JMiniXTestMBean");       
        mbs.registerMBean(instance, name);

        instance.run();
    }
}
