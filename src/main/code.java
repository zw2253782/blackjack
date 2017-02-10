
/*
public class code {
	AceCounter=0;
	player dealer = new player(deck);
    List<PokerCard> hand = new ArrayList<PokerCard>();
    hand.add(deck.drawCard());
    hand.add(deck.drawCard());
    System.out.println("Here is your hand: ");
    System.out.println("===========================");  
    System.out.println(hand.get(0).getRank());
    System.out.println(hand);
    int handvalue = calcHandValue(hand);
    System.out.println("The dealer is showing: ");
    System.out.println("===========================");  
    dealer.showFirstCard();
    if(hasBlackJack(handvalue) && dealer.hasBlackJack())//check if both the user and dealer have blackjack.
    {
        Push();
    }
    else if(hasBlackJack(handvalue))//check if the user has blackjack.
    {
        System.out.println("You have BlackJack!");
        System.out.println("You win 2x your money back!");
        Win();
    }
    else if(dealer.hasBlackJack())//check if the dealer has blackjack.
    {
        System.out.println("Here is the dealer's hand:");
        dealer.showHand();
        Lose();
    }
    else
    {   
        System.out.println("Would you like to hit or stand?");//ask if the user will hit or stand
        Scanner hitorstand = new Scanner(System.in);
        String hitter = hitorstand.nextLine();
        while(!isHitorStand(hitter))
        {
            System.out.println("Please enter 'hit' or 'stand'.");
            hitter = hitorstand.nextLine();
        }
        while(hitter.equals("hit"))//hits the user as many times as he or she pleases.
        {
            Hit(deck, hand);
            System.out.println("Your hand is now:");
            System.out.println(hand);
            handvalue = calcHandValue(hand);
            if(checkBust(handvalue))//checks if the user busted
            {
                Lose();
                break;
            }
            System.out.println("Would you like to hit or stand?");
            hitter = hitorstand.nextLine();
        }
        if(hitter.equals("stand"))//lets the user stand.
        {
            int dealerhand = dealer.takeTurn(deck);//takes the turn for the dealer.
            System.out.println("");
            System.out.println("Here is the dealer's hand:");
            dealer.showHand();
            if(dealerhand>21)//if the dealer busted, user wins.
            {
                Win();
            }
            else
            {
                int you = 21-handvalue;//check who is closer to 21 and determine winner
                int deal = 21-dealerhand;
                if(you==deal)
                {
                    Push();
                }
                if(you<deal)
                {
                    Win();
                }
                if(deal<you)
                {
                    Lose();
                }
            }
        }
    }
    */
