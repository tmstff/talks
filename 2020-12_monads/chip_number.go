package main

import (
	"fmt"
	"log"
)

type Pet struct { name string }
type Child struct { name string; pets []Pet }
type Parent struct { name string; children []Child }

func getChipNumber(petName string) (string, error) {
	switch petName {
	case "charly":
		return "12345", nil
	case "betty":
		return "23456", nil
	case "bobby":
		return "34567", nil
	default:
		return "", fmt.Errorf("no number present for %s", petName)
	}
}

var parents = []Parent{
	{"Judith", []Child{ {"Toby", []Pet{ {""}, {""} }} }},
	{"Nicco", []Child{ {"James", []Pet{ {"charly"}, {"betty"} }} }},
	{"Marie", []Child{ {"Mira", []Pet{ {"bobby"}, {"deafy"} }} }},
}

func main() {
	var numbers = make([]string, 0)

	for _, par := range parents {
		for _, child := range par.children {
			for _, pet := range child.pets {
				if pet.name != "" {
					number, err := getChipNumber(pet.name)
					if err != nil {
						continue
					}
					numbers = append(numbers, number)
				}
			}
		}
	}

	log.Printf("numbers: %v", numbers)
}
