
function checkPerfect(no)
{
    let i = 0;
    let sum = 0;

    for(i = 1; i <= no/2; i++)
    {
        if(no % i == 0)
        {
            sum = sum + i;
        }
    }

    return (sum == no)
}
function main()
{
    let bRet = checkPerfect(28);

    if(bRet)
    {
        console.log("number is perfect number")
    }
    else
    {
        console.log("number is not perfect number")
    }

}

main();