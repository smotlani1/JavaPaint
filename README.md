# Java Paint Application

This is a paint application based o.the Java Awt Package, 
implementing various design patterns
## Link to GitHub
https://github.com/smotlani1/SE450Final

## Design Patterns Used

### 1. Command Pattern

Classes Used: 
root = src <br/>
model.clickHandler <br/>
canvas.MouseModeCommandInterface <br/>
canvas.MouseModeCommandDraw <br/>
canvas.MouseModeCommandMove<br/>
canvas.MouseModeCommandSelect

### 2. Template Method
canvas.MouseModeCommandDraw <br/>
canvas.CreateRectangle <br/>
canvas.CreateTriangle<br/>
canvas.CreateEllipse
### 3. Abstract Fact. Method
canvas.ShapeFactoryAbstract <br/>
canvas.ShapeFactory <br/>
### 4. State Pattern
canvas.CreateRectangle <br/>
canvas.Rectangle.RectangleAbstract <br/>
canvas.Rectangle.Filled <br/>
canvas.Rectangle.Outlined <br/>
canvas.Rectangle.OutlineFill <br/>
*NOTE* Same pattern is implemented with CreateTriangle and CreateEllipse

### 5. Composite Pattern
canvas.MouseModeCommandDraw (Abstract) <br/>
canvas.Group.GroupShape (Container class) <br/>
canvas.CreateTriangle<br/>


## Bugs/Issues
1.The paintcanvase.repaint () method did not work. My work around to this was to draw a large white rectangle to cover the canvas every time paintCanvase.paint() is called. The application still works as expected visually <br/>
2 When undoing a group, the application has no visual confirmation of the ungrouping. Upon selection, you can see the ungrouping was completed. <br/>
3 Occasionally the undo button has to be double-clicked in order for it to work. 