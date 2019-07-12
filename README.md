# trainingTDD

This is a study about unitary tests in Java using JUnit.
Two design patterns (builder and factory) were also used in this project.

It is a simple project about negotiations and its representations in a CandleStick graphic.

This project has a package with 3 classes:
- **Negotiation**: Represents negotiations in the market.
- **CandleStick**: The representation of negotiations in candleStick graphic per day.
- **CandleStickFactory**: A factory for CandleStick class.

There is another package for the unitary tests (JUnit). This one with 4 classes.
- **TestNegotiation**: Contains the unitary tests for Negotiation class.
- **TestCandleStick**: Contains the unitary tests for CandleStick class.
- **TestCandleStickFactory**: Contains the unitary tests for CandleStickFactory class.
- **CandleBuilder**: A builder for CandleStick.

Finnaly, another packager with a single class named **XmlReader**, witch contains the main function.
In main we create a negotiation, a candlestick and convert it to XML.


