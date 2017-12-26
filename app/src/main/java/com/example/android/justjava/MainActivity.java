package com.example.android.justjava;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.text.BoringLayout;
        import android.util.Log;
        import android.view.View;
        import android.widget.CheckBox;
        import android.widget.TextView;
        import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrders(View view) {
        CheckBox getWhippedCream = (CheckBox) findViewById(R.id.WhippedCream);
        boolean hasWhippedCream = getWhippedCream.isChecked();
        int price = calculatePrice();
        String priceMessage = createOrderSummary(price, hasWhippedCream);
        displayMessage(priceMessage);

    }


    /**
     * Calculates the price of the order.
     * @return total price
     */
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }

    private String createOrderSummary(int price, boolean hasWhippedCream){
        String priceMessage = "Name: Kaptain Kunal";
        priceMessage += "\nAdd whipped cream? " + hasWhippedCream;
        priceMessage += "\nQuantity " + quantity;
        priceMessage += "\nTotal: " + calculatePrice();
        priceMessage += "\nThank you!";
        return priceMessage;

}


    private void displayMessage(String message) {
        TextView orderSummaryTextView= (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int liczba) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + liczba);
    }


}