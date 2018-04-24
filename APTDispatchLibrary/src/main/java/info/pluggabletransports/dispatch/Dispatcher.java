package info.pluggabletransports.dispatch;

import java.util.Properties;

import info.pluggabletransports.dispatch.transports.MeekTransport;
import info.pluggabletransports.dispatch.transports.Obfs4Transport;

public class Dispatcher implements DispatchConstants {

    private static Dispatcher _instance;

    private Dispatcher () {

        loadTransports();

    }

    public static synchronized Dispatcher get ()
    {
        if (_instance == null)
        {
            _instance = new Dispatcher();
        }

        return _instance;
    }

    private void loadTransports ()
    {
        //TODO: discover available transports here, and do what we need to get them ready
    }

    public Transport getTransport (String type, Properties options)
    {
        Transport transport = null;

        if (type.equals(PT_TRANSPORTS_MEEK))
            transport = new MeekTransport();
        else if (type.equals(PT_TRANSPORTS_OBFS4))
            transport = new Obfs4Transport();

        if (transport != null)
            transport.init(options);

        return transport;
    }

}
