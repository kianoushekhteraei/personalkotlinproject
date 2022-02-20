package andriod.kianoushekhteraei.kotlinproject.Fragments.Profile


sealed class UsersListEvent {


    object NewSearchEvent : UsersListEvent()

    object NextPageEvent : UsersListEvent()

    // restore after process death
    object RestoreStateEvent: UsersListEvent()
}