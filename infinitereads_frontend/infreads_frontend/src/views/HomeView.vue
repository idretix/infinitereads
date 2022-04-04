<template>
  
  <v-form
    ref="form"
    class="ml-6 mr-6"
  >
   <div class="font-italic">
    <h1>Welcome to Infinite Reads, the place where we brag about books we haven't read!</h1>
  </div>
      <v-btn
      color="success"
      class="mr-4"
      @click="$router.push({ name: 'login' })"
    >
      Login
    </v-btn>

    <v-btn
      color="error"
      class="mr-4"
      @click="$router.push({ name: 'register' })"
    >
      Register
    </v-btn>
      <v-btn
      color="purple"
      class="mr-4"
    >
      See Books
    </v-btn>
  </v-form>

</template>

<script>
 // import HelloWorld from '../components/HelloWorld'

  export default {
    name: 'HomeView',

    components: {
      //HelloWorld,
    },
  }
</script>
