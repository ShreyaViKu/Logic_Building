function checkEven(no)
{
    if(no % 2 == 0)
    {
        return true
    }
    else
    {
        return false
    }
}
function main()
{
    let value = 11;

    let bRet = checkEven(value);

    if(bRet == true)
    {
        console.log(`${value} is even number`)
    }
    else
    {
        console.log(`${value} is odd number`)
    }

}

main();