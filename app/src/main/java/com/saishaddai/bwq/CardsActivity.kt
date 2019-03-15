package com.saishaddai.bwq

import android.support.v7.app.AppCompatActivity


import android.os.Bundle
import com.saishaddai.bwq.adapter.CardsAdapter
import com.saishaddai.bwq.model.ViewModel
import kotlinx.android.synthetic.main.activity_cards.*

const val CARD_TYPE_ARG = "type"

class CardsActivity : AppCompatActivity() {

    private var type = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)
        intent?.let {
            type = it.getStringExtra(CARD_TYPE_ARG)
        }



        if(type == "Java") {
            val listOfCards = getCards()
            cardsPager.adapter = CardsAdapter(supportFragmentManager, listOfCards)
        } else {
            val listOfCards = getEmptyListOfCards()
            cardsPager.adapter = CardsAdapter(supportFragmentManager, listOfCards)
        }
    }

    private fun getEmptyListOfCards(): ArrayList<ViewModel.Card> {
        val listOfCards = arrayListOf<ViewModel.Card>()
        val finalCard = ViewModel.Card("B", "", "")
        listOfCards.add(finalCard)
        return listOfCards
    }

    private fun getCards(): ArrayList<ViewModel.Card> {
        val listOfCards = arrayListOf<ViewModel.Card>()
        val card1 = ViewModel.Card(
            "A",
            "Fragments onAttach method",
            "<p>Since API 23, on <i><font color=\"red\">attach(Activity)</font></i> is <b>deprecated</b>. It should be used <i><font color=\"red\">onAttach(Context)</font></i></p>"
        )
        val card2 = ViewModel.Card(
            "A",
            "Java/Kotlin interoperability",
            "<p>To use the activity's context, you call it in <b>Java</b> as <i>MainActivity.this</i>. In <b>Kotlin</b> it is <i><font color=\"red\">this@MainActivity</font></i></p>"
        )
        val card3 = ViewModel.Card(
            "A",
            "Java/Kotlin interoperability",
            "Java Virtual Machine(JVM) is the Target Platform of Kotlin. Kotlin is 100% interoperable with Java since both, on compilation produce bytecode. Hence Kotlin code can be called from Java and vice-versa."
        )
        val card4 = ViewModel.Card(
            "A",
            "val and var declarations",
            "val variables cannot be changed. They’re like final modifiers in Java. A var can be reassigned. The reassigned value must be of the same data type."
        )
        val card5 = ViewModel.Card(
            "A",
            "Elvis operator",
            "It’s represented as ?: over the nullable type. The value on the right hand side would be used if the nullable type holds a null.\n" +
                    "\n" +
                    "Copy\n" +
                    "var str: String?  = \"JournalDev.com\"\n" +
                    "var newStr = str?: \"Default Value\""
        )
        val card6 = ViewModel.Card(
            "A",
            "cons and val",
            "By default val properties are set at runtime. Adding a const modifier on a val would make a compile-time constant.\n" +
                    "A const cannot be used with a var or on its own.\n" +
                    "A const is not applicable on a local variable."
        )
        val card7 = ViewModel.Card(
            "A",
            "!! operator",
            "!! is used to force unwrap the nullable type to get the value. If the value returned is a null, it would lead to a runtime crash. Hence a !! operator should be only used when you’re absolutely sure that the value won’t be null at all. Otherwise, you’ll get the dreaded null pointer exception. On the other hand, a ?. is an Elvis Operator that does a safe call."
        )
        val card8 = ViewModel.Card(
            "A",
            "== and === operators",
            "== is used to compare the values are equal or not. === is used to check if the references are equal or not."
        )
        val card9 = ViewModel.Card(
            "A", "Visibility modifiers", "public\n" +
                    "internal\nprotected\nprivate\npublic is the default visibility modifier."
        )
        val card10 = ViewModel.Card(
            "A", "Constructors", "Constructors in Kotlin are of two types:\n" +
                    "Primary – These are defined in the class headers. They cannot hold any logic. There’s only one primary constructor per class.\n" +
                    "Secondary – They’re defined in the class body. They must delegate to the primary constructor if it exists. They can hold logic. There can be more than one secondary constructors.\n" +
                    "\n"
        )
        val card11 = ViewModel.Card(
            "A",
            "init block",
            "init is the initialiser block in Kotlin. It\\’s executed once the constructor is instantiated."
        )
        val card12 = ViewModel.Card(
            "A",
            "Arguments in constructor",
            "By default, the constructor arguments are val unless explicitly set to var."
        )
        val card13 = ViewModel.Card(
            "A", "Java/Kotlin interoperability", " in Kotlin, new isn’t a keyword.\n" +
                    "We can instantiate a class in the following way:\n" +
                    "\n" +
                    "Copy\n" +
                    "class A\n" +
                    "var a = A()\n" +
                    "val new = A()"
        )
        val card14 = ViewModel.Card("A", "Java/Kotlin interoperability", "when is the equivalent of switch in Kotlin.")
        val card15 = ViewModel.Card(
            "A",
            "Java/Kotlin interoperability",
            "n Java, to create a class that stores data, you need to set the variables, the getters and the setters, override the toString(), hash() and copy() functions.\n" +
                    "In Kotlin you just need to add the data keyword on the class and all of the above would automatically be created under the hood."
        )
        val card16 = ViewModel.Card(
            "A",
            "lateinit and lazy",
            "lateinit is a modifier used with var and is used to set the value to the var at a later point.\n" +
                    "lazy is a method or rather say lambda expression. It’s set on a val only. The val would be created at runtime when it’s required."
        )

        val card17 = ViewModel.Card(
            "A",
            "Singleton objects",
            "To use the singleton pattern for our class we must use the keyword object"
        )
        val card18 = ViewModel.Card(
            "A", "static keyword", "Kotlin doesn’t have the static keyword.\n" +
                    "To create static method in our class we use the companion object."
        )

        val card19 = ViewModel.Card(
            "A", "Extension Functions", "<p>Kotlin, similar to C# and Gosu, provides the ability to extend a class with new functionality without having to inherit from the class or use any type of design pattern such as Decorator. This is done via special declarations called extensions. Kotlin supports <I><font color=\"red\">extension functions</font></I> and <I><font color=\"red\">extension properties</font></I> Ex.</p><p>class Dog(val name: String, val breed: String)</p><p>fun Dog.bark() {println(“woof”)</p>"
        )

        val finalCard = ViewModel.Card("B", "", "")

        listOfCards.add(card1)
        listOfCards.add(card2)
        listOfCards.add(card3)
        listOfCards.add(card4)
        listOfCards.add(card5)
        listOfCards.add(card6)
        listOfCards.add(card7)
        listOfCards.add(card8)
        listOfCards.add(card9)
        listOfCards.add(card10)
        listOfCards.add(card11)
        listOfCards.add(card12)
        listOfCards.add(card13)
        listOfCards.add(card14)
        listOfCards.add(card15)
        listOfCards.add(card16)
        listOfCards.add(card17)
        listOfCards.add(card18)
        listOfCards.add(card19)


        listOfCards.add(finalCard)
        return listOfCards
    }

//    override fun onBackPressed() {
//        super.onBackPressed()
//    }
}
