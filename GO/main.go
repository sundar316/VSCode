package main

import "fmt"

func main() {
	//var conferenceName string = "SUNDAR" //method 1
	const conferenceTickets = 50		 //method 2
	remainingTickets := 50				 //method 3
	fmt.Println("Hello There!!!")
	fmt.Printf("Total Tickets: %v Available Tickets: %v\n", conferenceTickets, remainingTickets)
	fmt.Println("Get Your Tickets here...")

	var booking []string //slice
	//var booking [10]string //array
	//var booking = [10]string{} //array with default value

	fmt.Print("Enter Your Name: ")
	var userName string
	fmt.Scan(&userName)
	fmt.Print("Enter no. of tickets: ")
	var noOfTickets int
	fmt.Scan(&noOfTickets)
	fmt.Print("Enter email: ")
	var email string
	fmt.Scan(&email)

	fmt.Printf("Thank you %v, for booking %v tickets.\nYou will receive a conformation email at %v\n", userName, noOfTickets, email)
	booking = append(booking, userName)
	remainingTickets -= noOfTickets
	fmt.Println("Remaining Tickets:", remainingTickets)
}
