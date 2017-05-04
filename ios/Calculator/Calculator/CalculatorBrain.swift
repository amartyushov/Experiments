//
//  CalculatorBrain.swift
//  Calculator
//
//  Created by Aleksandr Martiushov on 02/02/17.
//  Copyright © 2017 Aleksandr Martiushov. All rights reserved.
//

import Foundation

class CalculatorBrain {
    
    // var opStack = Array<Op>() alternative declaration is below
    private var opStack = [Op]()
    
    // var knownOps = Dictionary<String, Op>() alternative declaration is below
    private var knownOps = [String:Op]()
    
    init() {
        // knownOps["multiply"] = Op.BinaryOperation("multiply") {$0 * $1} alternative
        knownOps["multiply"] = Op.BinaryOperation("multiply", *)
        knownOps["plus"] = Op.BinaryOperation("plus") {$0 + $1}
        knownOps["minus"] = Op.BinaryOperation("minus") {$1 - $0}
        knownOps["divide"] = Op.BinaryOperation("divide") {$1 / $0}
        // knownOps["sqrt"] = Op.UnaryOperation("sqrt") {sqrt($0)} alternative
        knownOps["sqrt"] = Op.UnaryOperation("sqrt", sqrt)
    }
    
    private enum Op {
        case Operand(Double)
        case UnaryOperation(String, (Double) -> Double)
        case BinaryOperation(String, (Double, Double) -> Double)
    }
    
    func pushOperand(operand: Double) {
        opStack.append(Op.Operand(operand))
    }
    
    func performOperation(symbol: String) {
        if let operation = knownOps[symbol]{
            opStack.append(operation)
        }
    }
    
    func evaluate() -> Double? { // it means it returns optional
        
    }
    
    func evaluate(ops: [Op]) -> (result: Double?, remainingOps: [Op]) { // ops is _let_ here
        if !ops.isEmpty{
            var remainingOps = ops // I have to copy to mutable struct, beacuse ops is immutable
            let op = remainingOps.removeLast()
            switch op {
            case Op.Operand(let operand):
                return (operand, remainingOps)
            case .UnaryOperation(_, let operation)
                let operandEvaluation = evaluate(remainingOps)
                if let operand operandEvaluation.result{
                    return (operation(operand), ...)
                }
            case .BinaryOperation(_, let operation)
                
            default:
                <#code#>
            }
            
        }
        
        return(nil, ops)
    }
    
}
