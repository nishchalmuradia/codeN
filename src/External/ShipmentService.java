/*
package External;
import io.prometheus.client.Counter;

public class ShipmentService {

    // Define the service types
    public enum ServiceType {
        E2E, FALLBACK
    }

    // Define the metrics counters
    private static final Counter e2eShipmentsCounter = Counter.build()
            .name("e2e_shipments_total")
            .help("Total number of shipments created via E2E services.")
            .register();

    private static final Counter fallbackShipmentsCounter = Counter.build()
            .name("fallback_shipments_total")
            .help("Total number of shipments created via fallback services.")
            .register();

    public void createShipment(ServiceType serviceType) {
        // Create the shipment using the specified service type
        if (serviceType == ServiceType.E2E) {
            e2eShipmentsCounter.inc();
        } else {
            fallbackShipmentsCounter.inc();
        }
    }
}*/
