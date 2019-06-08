package com.sakebakery.opus;

import java.util.List;
import java.util.Vector;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;


public class ShoppingCartHelper extends AppCompatActivity {

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Product> catalog;
    private static List<Product> cart;

    public static List<Product> getCatalog(Resources res) {
        if (catalog == null) {
            catalog = new Vector<Product>();
            catalog.add(new Product("Cake Rosette", res
                    .getDrawable(R.drawable.rose),
                    "Strawberry", "Cake Rosette cake is done with beautiful roses decorated with strawberry puree nestled in-between each layer and " +
                    "covered with a silky almond flavored frosting and finished with toasted sliced almonds.",
                    28500, "Chocolate", "Strawberry Cream", "Summer Fruit Fillings" ));
            catalog.add(new Product("Chocolate Mud Cake", res
                    .getDrawable(R.drawable.chococake),
                    "Chocolate", "This triple infusion of chocolate is pure rapture. Dark dense chocolate cake layered with chocolate mousse and dark chocolate butter cream that is studded with chocolate sprinkles. " +
                    "Chocolate coated cake with raspberry and strawberries! Fresh and fascinating",
                    20000, "Chocolate and Strawberries", "Chocolate Cream", "Chocolate Raspberry Filling"));
            catalog.add(new Product("East Village Cake", res
                    .getDrawable(R.drawable.vcake),
                    "Vanilla", "Alternating layers of buttery golden vanilla and chocolate cake, filled and frosted with our chocolate buttercream. " +
                    "East Village cakes are decorated with white ganache drizzle and white and chocolate curls. \n",
                    27000, "Whipped Cream with white Ganache", "Butter Cream", "Chocolate cake Filling"));
            catalog.add(new Product("Ready-made Birthday Cake", res
                    .getDrawable(R.drawable.bcake),
                    "Buttercream", "Simple and Colourful Birthday cake for everyone. This decadent White buttercream mud cake is perfect for a special occasion.",
                    22000, "Whipped Cream", "Vanilla Cream", "Butter Cream Filling"));
            catalog.add(new Product("Chocolate Peanut Butter Cup", res
                    .getDrawable(R.drawable.rich),
                    "Chocolate", "Moist, fudgy chocolate cake, filled and frosted with our creamy peanut butter buttercream. " +
                    "Peanut Butter Cup cakes are decorated with chocolate ganache drizzle" +
                    "chocolate curls and peanut butter cups", 25000,
                    "Chocolate", "Peanut Butter", "Buttercream Filling"));
            catalog.add(new Product("Spongy Durain Cake", res
                    .getDrawable(R.drawable.dcake),
                    "Durian", "Cottony sponge cake layered with a luscious durian filling made from SAKE durian flesh and fresh " +
                    "cream. We didn't add any sugar to the filling or whipped cream frosting as the cake and fruit impart enough sweetness on their own. ", 21500,
                    "Durain Cream", "Cream Cheese", "Summer Fruits Filling"));
            catalog.add(new Product("Vanilla Flower Cake", res
                    .getDrawable(R.drawable.flower),
                    "Vanilla", "Light and sweet but moist and rich in flavor, our Vanilla Almond cake " +
                    "is filled and frosted with our house vanilla buttercream. Vanilla Almond cakes are decorated with sparkly" +
                    " clear crystal sprinkles, pearl sprinkles and a ring of buttercream rosettes.", 24300,
                    "Strawberry, Whipped Cream", "Butter Cheese", "Cream Cheese Filling"));
            catalog.add(new Product("Heart-shaped Raspberry Cake", res
                    .getDrawable(R.drawable.hcake),
                    "Raspberry", "One of our most popular cakes, our red velvet is always moist and dense with a light chocolate flavor. It is perfectly paired when filled and frosted with our house vanilla buttercream." +
                    " Heart Shape Raspberry Cakes are decorated with red velvet cake crumbs and a ring of buttercream rosettes.\n",
                    15000, "Whipped Cream", "Red velvet cake crumbs", "Buttercream rosettes"));
            catalog.add(new Product("Red Velvet", res
                    .getDrawable(R.drawable.scake),
                    "Vanilla", "Moist Strawberry Vanilla Almond cake studded with confetti sprinkles in the batter. Confetti Amycakes are frosted with vanilla buttercream and decorated with colorful sprinkles.\n", 32000,
                    "Whipped Cream", "Strawberry flakes", "Strawberry Hazelnut Filling"));
            catalog.add(new Product("Munchy Chocolate Cake", res
                    .getDrawable(R.drawable.munch),
                    "Chocolate", "Rich, fudgy chocolate cake filled and frosted with our house chocolate buttercream. " +
                    "Double Chocolate cakes are decorated with chocolate flakes and chocolate ganache drizzle.\n",
                    18800, "Chocolate", "Chocolate Flakes", "Chocolate Hazelnut Filling"));
            catalog.add(new Product("Confetti Cake", res
                    .getDrawable(R.drawable.vcake),
                    "Butter Cream", "Old fashioned, buttery golden yellow cake, just as moist and dense as Grandma used to make. Filled and frosted with our house chocolate buttercream. " +
                    "Golden Chocolate Butter cakes are decorated with ascending gold sprinkles, chocolate ganache drizzle and dark chocolate curls and flakes. ",
                    17700, "Butter", "Butter Cream", "Summer Fruits Filling" ));
            catalog.add(new Product("White Chocolate Mud Cake", res
                    .getDrawable(R.drawable.wcake),
                    "Vanilla", "White chocolate cake with whipped cream. This decadent White chocolate mud cake is perfect for a special occasion.", 19600 ,
                    "Chocolate, Vanilla Cream", "Vanilla Cheese", "Cream Cheese Filling"));
            catalog.add(new Product("Snickerdoodle Cake", res
                    .getDrawable(R.drawable.vanillac),
                    "Vanilla", "Light and sweet but moist and rich in flavor, our Vanilla Almond cake is filled and frosted with our house vanilla buttercream. " +
                    "Rosette Vanilla Almond cakes are decorated with sparkly clear crystal sprinkles, pearl sprinkles and a ring of buttercream rosettes.", 25500,
                    "Milky Vanilla Cream", "White chocolate", "Cream Cheese and Almonds"));
            catalog.add(new Product("German Dark Chocolate Cake", res
                    .getDrawable(R.drawable.birthdaycakepng),
                    "Chocolate", "Moist, fudgy chocolate cake filled with creamy coconut pecan filling and chocolate ganache and semi- frosted on the sides with creamy chocolate buttercream." +
                    "Dark Chocolate German cakes are decorated with coconut pecan filling, a drizzle of ganache and pecan pieces.", 21800,
                    "Chocolate Ganache", "Dark Chocolate", "Creamy Coconut Pecan"));
            catalog.add(new Product("Irish Cream Torte", res
                    .getDrawable(R.drawable.blackfrost),
                    "Chocolate", "Irish cream flavored chocolate cake brushed with liquor and layered with chocolate mousse. Silky milk chocolate frosting covers the entire cake with a drizzle of chocolate ganache.", 21800,
                    "Chocolate Ganache", "Dark Chocolate flakes", "Chocolate Mousse"));

        }

        return catalog;
    }

    public static List<Product> getCart() {
        if (cart == null) {
            cart = new Vector<Product>();
        }

        return cart;
    }

}










