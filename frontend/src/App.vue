<template>
  <v-app>
    <v-app-bar app>
      <v-toolbar-title class="headline text-uppercase">
        <span>Events Scheduler</span>
        <span class="font-weight-light"> Events</span>
      </v-toolbar-title>

      <v-spacer></v-spacer>

      <v-toolbar-items>
        <v-btn text>Link 1</v-btn>
        <v-btn text>Link 2</v-btn>
        <v-btn text>Link 3</v-btn>
      </v-toolbar-items>

    </v-app-bar>

    <v-content>
      <ListMembres/>
      <ListCourses/>
      <Event/>
    </v-content>
  </v-app>

</template>

<script>
import ListMembres from "./components/ListMembres";
import ListCourses from "./components/ListCourses";
import Event from "./components/Event";

export default {
  name: 'App',

  components: {
    ListMembres,
    ListCourses,
    Event
  },

  data: () => ({
    //
  }),
};
</script>
