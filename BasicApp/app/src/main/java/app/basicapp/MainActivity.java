package app.basicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 1;

    public void increment(View view) {
        if (quantity == 20) {
            Toast.makeText(this,"You cannot have more than 20 ",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity++;
        displayQuantity(quantity);
        displayPrice(quantity * 5);

    }


    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(this,"You cannot have less than 1",Toast.LENGTH_SHORT).show();

            return;
        }
        quantity--;
        displayQuantity(quantity);
        displayPrice(quantity * 5);
    }

    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */
    private int calculatePrice(int quantity) {
        int price = quantity * 5;
        return price;
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
//        EditText nameField = (EditText) findViewById(R.id.name_field);
//        String name = nameField.getText().toString();
//
//        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
//        boolean addWhippedCream = whippedCreamCheckbox.isChecked();
//
//        CheckBox chocolateCheckbox = (CheckBox) findViewById(R.id.chocolate_checkbox);
//        boolean addChocolate = chocolateCheckbox.isChecked();
//
//        int basePrice = 5;
//        if (addWhippedCream)
//            basePrice = basePrice + 1;
//
//        if (addChocolate)
//            basePrice = basePrice + 2;
//
//        int price = quantity * basePrice;
//        String priceMessage = "";
//        priceMessage += "\nName : " + name;
//        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
//        priceMessage += "\nAdd chocolate? " + addChocolate;
//        priceMessage += "\nTotal: $" + price;
//        priceMessage = priceMessage + "\nThank you!";
//        displayMessage(priceMessage);

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if(intent.resolveActivity((getPackageManager()))!=null){
            startActivity(intent);
        }


    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}
