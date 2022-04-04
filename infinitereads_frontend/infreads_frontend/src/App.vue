<template>
  <v-app id="inspire">
    <!-- <v-navigation-drawer
      v-model="drawer"
      app
    >

    </v-navigation-drawer> -->

    <v-app-bar app>
      <!-- <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon> -->

      <v-toolbar-title>Infinite Reads</v-toolbar-title>
    </v-app-bar>

    <v-main>
      <!--  -->
        <router-view></router-view>

       <!-- <v-row>
        <v-col
          cols="12"
          sm="10"
          md="2"
        >
          <v-text-field
            label="Regular"
          ></v-text-field>
        </v-col>
       </v-row> -->

    </v-main>

  </v-app>
</template>

<script>

</script>