import { Component, OnInit } from '@angular/core';
import { ElementService } from 'src/app/services/element.service';
import { Element } from 'src/app/common/element';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-element-list',
  templateUrl: './element-list.component.html',
  styleUrls: ['./element-list.component.css']
})
export class ElementListComponent implements OnInit {

  elements : Element[] = [];

  constructor(private elementService:ElementService ){}

  ngOnInit(): void {   
     this.listElements();
  }

  listElements(){

    this.elementService.getElements().subscribe(
      data => {
        this.elements = data;
        console.log(data);
      }
    );
  }

  deleteElementById(idElement:string){
    Swal.fire({
      title: "Seguro, Eliminar?",
      text: "No se podra revertir!",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Si, eliminar!",
      cancelButtonText: "Cancelar"
    }).then((result) => {
      if (result.isConfirmed) {

        this.elementService.deleteElementById(idElement).subscribe(
          ()=>this.listElements()
        );

        Swal.fire({
          title: "Eliminado!",
          text: "El registro ha sido eliminado.",
          icon: "success"
        });
      }
    });
    
  }

}
