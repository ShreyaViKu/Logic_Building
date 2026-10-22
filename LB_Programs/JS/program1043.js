function Summation(Arr)
{
    let iSum = 0;
    let i = 0;

    for(i = 0; i <Arr.length; i++)
    {
        iSum = iSum + Arr[i];
    }

    return iSum;

}

function main()
{

    let Arr = [10,20,30,40];

    let iRet = Summation(Arr);

    console.log("Summation is :",iRet)

}

main();