package com.saishaddai.bwq.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.saishaddai.bwq.R
import com.saishaddai.bwq.model.ViewModel


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_CARD = "card"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CardFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CardFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class CardFragment : Fragment() {
    private var cardItem: ViewModel.Card? = null
    private lateinit var cardContainer: LinearLayout
    private lateinit var finalCardContainer: RelativeLayout
    private lateinit var titleTV: TextView
    private lateinit var contentTV: TextView
    private lateinit var finishButton: Button

    //private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cardItem = it.getParcelable(ARG_CARD)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_card, container, false)
        titleTV = view.findViewById(R.id.titleTV)
        contentTV = view.findViewById(R.id.contentTV)
        finishButton = view.findViewById(R.id.finishButton)

        cardContainer = view.findViewById(R.id.cardContainer)
        finalCardContainer = view.findViewById(R.id.finalCardContainer)


        val cardItem = arguments?.get(ARG_CARD) as ViewModel.Card
        if(cardItem.type == "A") {
            cardContainer.visibility = View.VISIBLE
            finalCardContainer.visibility = View.GONE
            titleTV.text = cardItem.title
            contentTV.text = cardItem.content
        } else {
            cardContainer.visibility = View.GONE
            finalCardContainer.visibility = View.VISIBLE
            finishButton.setOnClickListener {
                activity?.let { callingActivity -> callingActivity.finish() }
            }
        }



        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        //listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        if (context is OnFragmentInteractionListener) {
//            listener = context
//        } else {
//            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
//        }
    }

    override fun onDetach() {
        super.onDetach()
        //listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        //fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CardFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(cardParam : ViewModel.Card) =
            CardFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_CARD, cardParam)
                }
            }
    }
}
