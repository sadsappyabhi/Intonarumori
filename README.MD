# Intonarumori
### Inventory Tracking System for Record Stores and Labels

Intonarumori is an inventory tracking system aimed at Record Stores and Labels within the underground and niche genre communities. 


***
## Notes / TODO:
Products:
- Vinyl
- Cassette
- CD
- Zine
- Gift Card
- Clothing (T-shirts, Hoodies)
- Buttons/Pins/Stickers

Vinyl can have additional designation of LP or EP (12" or 7") (enum?)
Clothing classes (T-shirt/Hoodie) can inherit most methods from an abstract clothing class.

Order of Product Attributes:
- Name (or Artist/Title for Music)
- ID
- Price
- Description
- Quantity 

## FIXME: 
- ~~Product classes and their test cases.~~ Add a clothing/apparel product class, as well as a 'misc merch' 
  that can be a catch-all for buttons/stickers/pins or any other items that don't fit into another category. 
- Finish product classes and tests before writing Lookup tests (lookup tests require working with Product objects).
- `LookupName.matches()` will need to be refactored after creating Clothing classes in order to achieve 100% coverage.
- MusicProduct class needs an overridden `toString()` method still. (Each MusicProduct class has a unique identifier 
  e.g. LP/EP for Vinyl, CD/CDR and 80mm/120mm for CDs, duration for tape)
- Implementation needed for file i/o and order processing.
- PurchaseOrder class should use Lists rather than Arrays.
