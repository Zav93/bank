package bankaccount;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

public class RunningThreadTest {

    public static void main(String[] args) throws InterruptedException, SAXException,
            ParserConfigurationException {

        SAXParserFactory spfac = SAXParserFactory.newInstance();
        SAXParser sp = spfac.newSAXParser();
        BankAccountManager manager = new BankAccountManager(new BankAccount());
        //sp.parse("config.xml",manager);

        Husband husband = new Husband(manager, 1200.0, 0.0);
        Wife wife = new Wife(manager, 400.0, 500.0);
        Thread thread1 = new Thread(husband);
        Thread thread2 = new Thread(wife);
        thread1.start();
        thread2.start();

    }
}