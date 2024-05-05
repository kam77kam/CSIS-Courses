package src;

//Enum class for Chance cards
public enum ChanceCard {
 ADVANCE_TO_BOARDWALK("Advance to Boardwalk"),
 ADVANCE_TO_GO("Advance to Go (Collect $200)"),
 ADVANCE_TO_ILLINOIS("Advance to Illinois Avenue. If you pass Go, collect $200"),
 ADVANCE_TO_ST_CHARLES("Advance to St. Charles Place. If you pass Go, collect $200"),
 ADVANCE_TO_NEAREST_RAILROAD("Advance to the nearest Railroad. If unowned, you may buy it from the Bank. If owned, pay owner twice the rental."),
 ADVANCE_TO_NEAREST_UTILITY("Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times amount thrown."),
 BANK_DIVIDEND("Bank pays you dividend of $50"),
 GET_OUT_OF_JAIL("Get Out of Jail Free"),
 GO_BACK_3_SPACES("Go Back 3 Spaces"),
 GO_TO_JAIL("Go to Jail. Go directly to Jail, do not pass Go, do not collect $200"),
 MAKE_GENERAL_REPAIRS("Make general repairs on all your property. For each house pay $25. For each hotel pay $100"),
 SPEEDING_FINE("Speeding fine $15"),
 TRIP_TO_READING("Take a trip to Reading Railroad. If you pass Go, collect $200"),
 CHAIRMAN_OF_THE_BOARD("You have been elected Chairman of the Board. Pay each player $50"),
 BUILDING_LOAN_MATURES("Your building loan matures. Collect $150");

 private final String description; // Description of the card

 // Constructor
 ChanceCard(String description) {
     this.description = description;
 }

 // Getter for description
 public String getDescription() {
     return description;
 }
}
