<template>
  <v-app>
    <v-app-bar app>
      <v-toolbar-title class="headline text-uppercase">
        <span>Courses Scheduler</span>
        <span class="font-weight-light"> TENNIS</span>
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
    </v-content>
  </v-app>

</template>

<script>
import ListMembres from "./components/ListMembres";
import ListCourses from "./components/ListCourses";

export default {
  name: 'App',

  components: {
    ListMembres,
    ListCourses
  },

  data: () => ({
    //
  }),
};
</script>
