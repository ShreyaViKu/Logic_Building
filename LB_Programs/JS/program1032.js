function checkEven(no)
{
    return (no % 2 == 0)
}
function main()
{
    let value = 10;

    let bRet = checkEven(value);

    if(bRet)
    {
        console.log(`${value} is even number`)
    }
    else
    {
        console.log(`${value} is odd number`)
    }

}

main();