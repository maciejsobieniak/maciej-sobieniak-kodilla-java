package com.kodilla.stream.invoice.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SimpleInvoice class represents an invoice containing a list of items.
 * It provides methods to add and remove items, and to calculate the total value to pay.
 */
public class SimpleInvoice {

    private final List<SimpleItem> items = new ArrayList<>();

    public void addItem(SimpleItem item) {
        items.add(item);
    }

    public boolean removeItem(SimpleItem item) {
        return items.remove(item);
    }

    /**
     * Retrieves the list of items in the invoice.
     *
     * @return a list of SimpleItem objects
     */
    public double getValueToPay() {
        return items.stream()
                .collect(Collectors.summingDouble(SimpleItem::getValue));
    }
}
