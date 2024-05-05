package src;

//Enum class for Community Chest cards
public enum CommunityChestCard {
 ADVANCE_TO_GO("Advance to Go (Collect $200)"),
 BANK_ERROR("Bank error in your favor. Collect $200"),
 DOCTORS_FEE("Doctor’s fee. Pay $50"),
 SALE_OF_STOCK("From sale of stock you get $50"),
 GET_OUT_OF_JAIL("Get Out of Jail Free"),
 GO_TO_JAIL("Go to Jail. Go directly to jail, do not pass Go, do not collect $200"),
 HOLIDAY_FUND("Holiday fund matures. Receive $100"),
 INCOME_TAX_REFUND("Income tax refund. Collect $20"),
 BIRTHDAY("It is your birthday. Collect $10 from every player"),
 LIFE_INSURANCE("Life insurance matures. Collect $100"),
 HOSPITAL_FEES("Pay hospital fees of $100"),
 SCHOOL_FEES("Pay school fees of $50"),
 CONSULTANCY_FEE("Receive $25 consultancy fee"),
 STREET_REPAIR("You are assessed for street repair. $40 per house. $115 per hotel"),
 BEAUTY_CONTEST("You have won second prize in a beauty contest. Collect $10"),
 INHERITANCE("You inherit $100");

 private final String description; // Description of the card

 // Constructor
 CommunityChestCard(String description) {
     this.description = description;
 }

 // Getter for description
 public String getDescription() {
     return description;
 }
}

