## Bug 1 
Brief description: this.price was hardcoded to 0, ignoring param.
Failed unit test: testComputerPriceConstructor()

## Bug 2
Brief description: this.memory was hardcoded to 16, ignoring param.
Failed unit test: testComputerMemoryConstructor()

## Bug 3
Brief description: SetOS() was set to none so it will be stuck at none. 
Failed unit test: testSetOS()

## Bug 4
Brief description: buy() doesn't have runtime exception for duplicates
Failed unit test: testBuyDuplicateThrows()

## Bug 5
Brief description: printInventory() uses <= instead of <. This can cause a IndexOutOfBoundsException.
Failed unit test: testPrintInventoryNoException()

## Bug 6
Brief description: sell() doesn't use RuntimeException when computer isn't in inventory
Failed unit test: testSellNotInInventoryThrows()

## Bug 7
Brief description: refurbish() uses != for String comparison (it should use .equals() instead for this situation)
Failed unit test: testRefurbishUpdatesOS()

## Bug 8
Brief description: refurbish() sets price to 2500 for 2000–2011 computers. This doesn't follow the pattern of price being higher than newer computers.
Failed unit test: testRefurbishPrice2000to2011()

## Bug 9
Brief description: ResaleShop() begins with a computer already in inventory 
Failed unit test: ResaleShop() 

## Bug 10
Brief description: buy() ignores the computer passed in and instead creates and adds a hardcoded computer.
Failed unit test: testBuyAddsPassedComputer()