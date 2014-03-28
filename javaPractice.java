//just some practice problems from coding bat to get back into the swing
//Warmup 1 sleepIn
public boolean sleepIn(boolean weekday, boolean vacation){
    return vacation || !weekday;
}

//monkeyTrouble
public boolean monkeyTrouble(boolean aSmile, boolean bSmile){
    return (aSmile && bSmile) || (!aSmile && !bSmile);
}

//sumDouble
public int sumDouble(int a, int b){
    if (a != b){
	return a + b;
    }
    return 4 * a;
}

//diff21
public int diff21(int n){
    if (n > 21){
	return 2 * (n-21);
    }
    return 21 - n;
}

//parrotTrouble
public boolean parrotTrouble(boolean talking, int hour){
    return talking && (hour > 20 || hour < 7);
}

//makes10
public boolean makes10(int a, int b){
    return (a == 10 || b == 10 || a + b == 10);
}