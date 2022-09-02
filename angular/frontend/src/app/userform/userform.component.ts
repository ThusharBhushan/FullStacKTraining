import { HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'userform',
  templateUrl: './userform.component.html',
  styleUrls: ['./userform.component.css']
})
export class UserformComponent implements OnInit {
  user = {
    name: 'Thushar',
    age: 10,
    dob: new Date()
  }
  users: any[] = [];
  constructor(public userService: UserService) { }


  deleteUser(id:number){
    const observable = this.userService.deleteUser(id);
    observable.subscribe((usersFromServer :any)=>{
      this.users=usersFromServer
      this.userService.getAllUser();
})

  }
  saveUser() {
    console.log('clicked');
    this.user.dob = new Date(this.user.dob);
    const promise = this.userService.save(this.user);
    promise.subscribe((responseBody: any) => {
      console.log(responseBody);
      this.users.push(responseBody);
    },
      (error: any) => {
        console.log(error);
      }
    );
  }
  ngOnInit(): void {
  }

}