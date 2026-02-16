package Utilidades;

import com.genoma.plus.controller.general.dto.EventSubscriberDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.sse.InboundSseEvent;
import javax.ws.rs.sse.SseEventSource;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/SseListener.class */
public class SseListener {
    private SseEventSource eventSource;
    private Client client = ClientBuilder.newClient();
    private List<EventSubscriberDTO> subscribers = new ArrayList();

    public SseListener(String uri) {
        this.eventSource = SseEventSource.target(this.client.target(uri)).build();
    }

    public void startListening() {
        this.eventSource.register(this::handleEvent);
        this.eventSource.open();
    }

    private void handleEvent(InboundSseEvent event) {
        String eventType = event.getName();
        for (EventSubscriberDTO subscriber : this.subscribers) {
            if (subscriber.shouldReceive(eventType)) {
                subscriber.getConsumer().accept(event.readData());
            }
        }
    }

    public EventSubscriberDTO subscribe(String eventType, Consumer<String> consumer) {
        EventSubscriberDTO subscriber = new EventSubscriberDTO(eventType, consumer);
        this.subscribers.add(subscriber);
        return subscriber;
    }

    public void unsubscribe(EventSubscriberDTO subscriber) {
        this.subscribers.remove(subscriber);
    }

    public void stop() {
        this.eventSource.close();
        this.client.close();
    }
}
