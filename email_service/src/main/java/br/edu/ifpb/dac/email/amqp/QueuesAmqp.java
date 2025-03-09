package br.edu.ifpb.dac.email.amqp;

public enum QueuesAmqp {

    EMAIL_QUEUE("email-queue"),

    EXCHANGE("exchange"),

    EMAIL_QUEUE_ROUTING_KEY("email");

    private final String value;

    QueuesAmqp(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
