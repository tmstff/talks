package main

func findProduct(search string) (string, error) { return "product-key", nil}
func getPrice(productId string) (string, error) { return "1.20€", nil }
func addTaxes(country string, productId string) (string, error) { return "1.33€", nil }
func convertPrice(currency string, productId string) (string, error) { return "1.44" + currency, nil }

var country = "US"
var currency = "$"

func main() {
	prod, err := findProduct("IPhone 12")
	if err != nil {
		panic(err)
	}

	price, err := getPrice(prod)
	if err != nil {
		panic(err)
	}

	priceInclTax, err := addTaxes(country, price)
	if err != nil {
		panic(err)
	}

	convertedPrice, err := convertPrice(currency, priceInclTax)

	print(convertedPrice)
}
