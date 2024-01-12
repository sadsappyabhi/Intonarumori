# Intonarumori
### Inventory Tracking System for Record Stores and Labels

Intonarumori is an inventory tracking system aimed at Record Stores and Labels within the underground and niche genre communities. 

This is a slowly-evolving work-in-progress project that I am using to practice/showcase my abilities while I 
continue my coursework towards my B.S. in Computer Science. This is why you will likely see the majority of commits 
taking place between semesters.
***
## Notes / TODO:
Products:
- Vinyl
- Cassette
- CD
- Zine
- Gift Card

Vinyl can have additional designation of LP or EP (12" or 7") (enum?)

CD can have further distinction of mini-CDR (boolean)

Cassette will have length property (String e.g. C-20)

Order of Product Attributes:
- Name (or Artist/Title for Music)
- ID
- Price
- Description
- Quantity 

## FIXME: 
- Finish product classes and tests before writing Lookup tests (lookup tests require working with Product objects).
- MusicProduct class needs an overridden `toString()` method still. (Each MusicProduct class has a unique identifier 
  e.g. LP/EP for Vinyl, CD/CDR and 80mm/120mm for CDs, duration for tape)
- Implementation needed for file i/o and order processing.
- PurchaseOrder class should use Lists rather than Arrays.
