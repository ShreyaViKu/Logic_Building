function Addition(Value1, Value2)
{
    let ans = Value1 + Value2;

    return ans;
}

function main()
{
    let no1 = 10;
    let no2 = 11;

    let ans = 0;

    ans = Addition(no1,no2);

    console.log(`Addition of ${no1} & ${no2} is : ${ans}`);

}

main();